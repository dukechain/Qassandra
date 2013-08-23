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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cassandra.concurrent.scheduler.IsUserOperation;
import org.apache.cassandra.net.IVerbHandler;
import org.apache.cassandra.net.MessageIn;
import org.apache.cassandra.net.MessageOut;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.prediction.ReadExecutionTimePrediction;
import org.apache.cassandra.service.StorageService;
import org.apache.cassandra.tracing.Tracing;
import org.apache.cassandra.utils.ByteBufferUtil;

public class ReadVerbHandler implements IVerbHandler<ReadCommand>
{
    private static final Logger logger = LoggerFactory.getLogger( ReadVerbHandler.class );

    public void doVerb(MessageIn<ReadCommand> message, int id)
    {
        if (StorageService.instance.isBootstrapMode())
        {
            throw new RuntimeException("Cannot service reads while bootstrapping!");
        }

        ReadCommand command = message.payload;
        
        Table table;
        Row row;
        
        if (IsUserOperation.isUserReadCommand(command))
        { // chen add
            command.para_wrapper.local_start_time = System.currentTimeMillis();
            
            table = Table.open(command.table);
            row = command.getRow(table);
            
            command.para_wrapper.local_finished_time = System.currentTimeMillis();
            
            command.para_wrapper.set_actual_QC_k();
            
            ReadExecutionTimePrediction predict = new ReadExecutionTimePrediction();
            
            predict.time_save(command, command.para_wrapper.actual_QC_k);
        }
        else {
            table = Table.open(command.table);
            row = command.getRow(table);
        }
        
        

        MessageOut<ReadResponse> reply = new MessageOut<ReadResponse>(MessagingService.Verb.REQUEST_RESPONSE,
                                                                      getResponse(command, row),
                                                                      ReadResponse.serializer);
        Tracing.trace("Enqueuing response to {}", message.from);
        MessagingService.instance().sendReply(reply, id, message.from);
    }

    public static ReadResponse getResponse(ReadCommand command, Row row)
    {
        if (command.isDigestQuery())
        {
            if (logger.isTraceEnabled())
                logger.trace("digest is " + ByteBufferUtil.bytesToHex(ColumnFamily.digest(row.cf)));
            //return new ReadResponse(ColumnFamily.digest(row.cf));
            // chen modify
            
            ReadResponse res = new ReadResponse(ColumnFamily.digest(row.cf));
            
            res.para_wrapper = command.para_wrapper;
            
            return res;
            
        }
        else
        {
            ReadResponse res = new ReadResponse(row);
            // chen add
            res.para_wrapper = command.para_wrapper;
            
            return res;
        }
    }
}
