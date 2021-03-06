package org.apache.cassandra.io.compress;
/*
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;

import com.google.common.util.concurrent.RateLimiter;

import org.apache.cassandra.io.util.PoolingSegmentedFile;
import org.apache.cassandra.io.util.RandomAccessReader;

public class CompressedThrottledReader extends CompressedRandomAccessReader
{
    private final RateLimiter limiter;

    public CompressedThrottledReader(String file, CompressionMetadata metadata, RateLimiter limiter) throws FileNotFoundException
    {
        super(file, metadata, null);
        this.limiter = limiter;
    }

    protected void reBuffer()
    {
        limiter.acquire(buffer.length);
        super.reBuffer();
    }

    public static CompressedThrottledReader open(String file, CompressionMetadata metadata, RateLimiter limiter)
    {
        try
        {
            return new CompressedThrottledReader(file, metadata, limiter);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
