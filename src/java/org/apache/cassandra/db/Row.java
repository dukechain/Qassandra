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
package org.apache.cassandra.db;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicStampedReference;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.filter.IDiskAtomFilter;
import org.apache.cassandra.db.marshal.CompositeType;
import org.apache.cassandra.db.marshal.UTF8Type;
import org.apache.cassandra.io.IVersionedSerializer;
import org.apache.cassandra.io.util.DataOutputBuffer;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.utils.ByteBufferUtil;

public class Row
{
    public static final RowSerializer serializer = new RowSerializer();

    public final DecoratedKey key;
    //public final ColumnFamily cf;
    
    public ColumnFamily cf;

    public Row(DecoratedKey key, ColumnFamily cf)
    {
        assert key != null;
        // cf may be null, indicating no data
        this.key = key;
        this.cf = cf;
    }

    public Row(ByteBuffer key, ColumnFamily updates)
    {
        this(StorageService.getPartitioner().decorateKey(key), updates);
    }
    
    
    public Row(ReadCommand rc)
    {
        ByteBuffer key = rc.key;
        
        CFMetaData cfMetaData = new CFMetaData(rc.getKeyspace(), 
                rc.getColumnFamilyName(), 
                ColumnFamilyType.Standard, 
                UTF8Type.instance);
        
        cf = AtomicSortedColumns.factory.create(cfMetaData);
        
        this.key = StorageService.getPartitioner().decorateKey(key);
    }

    @Override
    public String toString()
    {
        return "Row(" +
               "key=" + key +
               ", cf=" + cf +
               ')';
    }

    public int getLiveCount(IDiskAtomFilter filter)
    {
        return cf == null ? 0 : filter.getLiveCount(cf);
    }
    
    public ByteBuffer toByteBuffer(String value) 
    {
        byte [] array = null;
        try
        {
            array =value.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        return ByteBuffer.wrap(array);
    }
    
    public void addSchedulerWrapper(ReadCommand rc) 
    {
        if (cf == null)
        {
            CFMetaData cfMetaData = new CFMetaData(rc.getKeyspace(), 
                    rc.getColumnFamilyName(), 
                    ColumnFamilyType.Standard, 
                    UTF8Type.instance);
            
            cf = AtomicSortedColumns.factory.create(cfMetaData);
        }
        
        addSchedulerWrapper(rc.para_wrapper);
    }
    
    public void addSchedulerWrapper(SchedulerParameter para) 
    {
        ByteBuffer name = toByteBuffer("scheduler");
        
        if (cf.getType()==ColumnFamilyType.Super)
        {
            name = CompositeType.build(name, name);
        }
        
        ByteBuffer value = para.toByteBuffer();
        
        Column col = new Column(name, value);
        
        cf.addColumn(col);
    }

    public static class RowSerializer implements IVersionedSerializer<Row>
    {
        public void serialize(Row row, DataOutput out, int version) throws IOException
        {
            ByteBufferUtil.writeWithShortLength(row.key.key, out);
            ColumnFamily.serializer.serialize(row.cf, out, version);
        }

        public Row deserialize(DataInput in, int version, ColumnSerializer.Flag flag) throws IOException
        {
            return new Row(StorageService.getPartitioner().decorateKey(ByteBufferUtil.readWithShortLength(in)),
                           ColumnFamily.serializer.deserialize(in, flag, version));
        }

        public Row deserialize(DataInput in, int version) throws IOException
        {
            return deserialize(in, version, ColumnSerializer.Flag.LOCAL);
        }

        public long serializedSize(Row row, int version)
        {
            int keySize = row.key.key.remaining();
            return TypeSizes.NATIVE.sizeof((short) keySize) + keySize + ColumnFamily.serializer.serializedSize(row.cf, TypeSizes.NATIVE, version);
        }
    }
    
}
