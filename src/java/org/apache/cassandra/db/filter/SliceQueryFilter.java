/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.db.filter;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cassandra.db.*;
import org.apache.cassandra.db.columniterator.ISSTableColumnIterator;
import org.apache.cassandra.db.columniterator.OnDiskAtomIterator;
import org.apache.cassandra.db.columniterator.SSTableSliceIterator;
import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.CompositeType;
import org.apache.cassandra.io.IVersionedSerializer;
import org.apache.cassandra.io.sstable.SSTableReader;
import org.apache.cassandra.io.util.FileDataInput;
import org.apache.cassandra.tracing.Tracing;

public class SliceQueryFilter implements IDiskAtomFilter
{
    private static final Logger logger = LoggerFactory.getLogger(SliceQueryFilter.class);
    public static final Serializer serializer = new Serializer();

    public final ColumnSlice[] slices;
    public final boolean reversed;
    public volatile int count;
    public final int compositesToGroup;

    // Not serialized, just a ack for range slices to find the number of live column counted, even when we group
    private ColumnCounter columnCounter;

    public SliceQueryFilter(ByteBuffer start, ByteBuffer finish, boolean reversed, int count)
    {
        this(new ColumnSlice[] { new ColumnSlice(start, finish) }, reversed, count);
    }

    public SliceQueryFilter(ByteBuffer start, ByteBuffer finish, boolean reversed, int count, int compositesToGroup)
    {
        this(new ColumnSlice[] { new ColumnSlice(start, finish) }, reversed, count, compositesToGroup);
    }

    /**
     * Constructor that accepts multiple slices. All slices are assumed to be in the same direction (forward or
     * reversed).
     */
    public SliceQueryFilter(ColumnSlice[] slices, boolean reversed, int count)
    {
        this(slices, reversed, count, -1);
    }

    public SliceQueryFilter(ColumnSlice[] slices, boolean reversed, int count, int compositesToGroup)
    {
        this.slices = slices;
        this.reversed = reversed;
        this.count = count;
        this.compositesToGroup = compositesToGroup;
    }

    public SliceQueryFilter cloneShallow()
    {
        return new SliceQueryFilter(slices, reversed, count, compositesToGroup);
    }

    public SliceQueryFilter withUpdatedCount(int newCount)
    {
        return new SliceQueryFilter(slices, reversed, newCount, compositesToGroup);
    }

    public SliceQueryFilter withUpdatedSlices(ColumnSlice[] newSlices)
    {
        return new SliceQueryFilter(newSlices, reversed, count, compositesToGroup);
    }

    public SliceQueryFilter withUpdatedSlice(ByteBuffer start, ByteBuffer finish)
    {
        return new SliceQueryFilter(new ColumnSlice[]{ new ColumnSlice(start, finish) }, reversed, count, compositesToGroup);
    }

    public OnDiskAtomIterator getMemtableColumnIterator(ColumnFamily cf, DecoratedKey key)
    {
        return Memtable.getSliceIterator(key, cf, this);
    }

    public ISSTableColumnIterator getSSTableColumnIterator(SSTableReader sstable, DecoratedKey key)
    {
        return new SSTableSliceIterator(sstable, key, slices, reversed);
    }

    public ISSTableColumnIterator getSSTableColumnIterator(SSTableReader sstable, FileDataInput file, DecoratedKey key, RowIndexEntry indexEntry)
    {
        return new SSTableSliceIterator(sstable, file, key, slices, reversed, indexEntry);
    }

    public Comparator<Column> getColumnComparator(AbstractType<?> comparator)
    {
        return reversed ? comparator.columnReverseComparator : comparator.columnComparator;
    }

    public void collectReducedColumns(ColumnFamily container, Iterator<Column> reducedColumns, int gcBefore)
    {
        columnCounter = getColumnCounter(container);

        while (reducedColumns.hasNext())
        {
            Column column = reducedColumns.next();
            if (logger.isTraceEnabled())
                logger.trace(String.format("collecting %s of %s: %s",
                                           columnCounter.live(), count, column.getString(container.getComparator())));

            columnCounter.count(column, container);

            if (columnCounter.live() > count)
                break;

            // but we need to add all non-gc-able columns to the result for read repair:
            if (QueryFilter.isRelevant(column, container, gcBefore))
                container.addColumn(column);
        }

        Tracing.trace("Read {} live and {} tombstoned cells", columnCounter.live(), columnCounter.ignored());
    }

    public int getLiveCount(ColumnFamily cf)
    {
        ColumnCounter counter = getColumnCounter(cf);
        for (Column column : cf)
            counter.count(column, cf);
        return counter.live();
    }

    private ColumnCounter getColumnCounter(ColumnFamily container)
    {
        AbstractType<?> comparator = container.getComparator();
        if (compositesToGroup < 0)
            return new ColumnCounter();
        else if (compositesToGroup == 0)
            return new ColumnCounter.GroupByPrefix(null, 0);
        else
            return new ColumnCounter.GroupByPrefix((CompositeType)comparator, compositesToGroup);
    }

    public void trim(ColumnFamily cf, int trimTo)
    {
        ColumnCounter counter = getColumnCounter(cf);

        Collection<Column> columns = reversed
                                   ? cf.getReverseSortedColumns()
                                   : cf.getSortedColumns();

        for (Iterator<Column> iter = columns.iterator(); iter.hasNext(); )
        {
            Column column = iter.next();
            counter.count(column, cf);

            if (counter.live() > trimTo)
            {
                iter.remove();
                while (iter.hasNext())
                {
                    iter.next();
                    iter.remove();
                }
            }
        }
    }

    public ByteBuffer start()
    {
        return this.slices[0].start;
    }

    public ByteBuffer finish()
    {
        return this.slices[slices.length - 1].finish;
    }

    public void setStart(ByteBuffer start)
    {
        assert slices.length == 1;
        this.slices[0] = new ColumnSlice(start, this.slices[0].finish);
    }

    public int lastCounted()
    {
        return columnCounter == null ? 0 : columnCounter.live();
    }

    @Override
    public String toString()
    {
        return "SliceQueryFilter [reversed=" + reversed + ", slices=" + Arrays.toString(slices) + ", count=" + count + ", toGroup = " + compositesToGroup + "]";
    }

    public boolean isReversed()
    {
        return reversed;
    }

    public void updateColumnsLimit(int newLimit)
    {
        count = newLimit;
    }

    public boolean maySelectPrefix(Comparator<ByteBuffer> cmp, ByteBuffer prefix)
    {
        for (ColumnSlice slice : slices)
            if (slice.includes(cmp, prefix))
                return true;
        return false;
    }

    public static class Serializer implements IVersionedSerializer<SliceQueryFilter>
    {
        public void serialize(SliceQueryFilter f, DataOutput out, int version) throws IOException
        {
            out.writeInt(f.slices.length);
            for (ColumnSlice slice : f.slices)
                ColumnSlice.serializer.serialize(slice, out, version);
            out.writeBoolean(f.reversed);
            int count = f.count;
            out.writeInt(count);

            out.writeInt(f.compositesToGroup);
        }

        public SliceQueryFilter deserialize(DataInput in, int version) throws IOException
        {
            ColumnSlice[] slices;
            slices = new ColumnSlice[in.readInt()];
            for (int i = 0; i < slices.length; i++)
                slices[i] = ColumnSlice.serializer.deserialize(in, version);
            boolean reversed = in.readBoolean();
            int count = in.readInt();
            int compositesToGroup = -1;
            compositesToGroup = in.readInt();

            return new SliceQueryFilter(slices, reversed, count, compositesToGroup);
        }

        public long serializedSize(SliceQueryFilter f, int version)
        {
            TypeSizes sizes = TypeSizes.NATIVE;

            int size = 0;
            size += sizes.sizeof(f.slices.length);
            for (ColumnSlice slice : f.slices)
                size += ColumnSlice.serializer.serializedSize(slice, version);
            size += sizes.sizeof(f.reversed);
            size += sizes.sizeof(f.count);

            size += sizes.sizeof(f.compositesToGroup);
            return size;
        }
    }
}
