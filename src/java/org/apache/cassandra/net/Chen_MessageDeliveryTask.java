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
package org.apache.cassandra.net;



import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.db.RowMutation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Chen_MessageDeliveryTask extends RWTask
{
    private static final Logger logger = LoggerFactory.getLogger(MessageDeliveryTask.class);

    private final MessageIn message;
    private final long constructionTime;
    private final int id;
    
    
    protected boolean installed;

    public Chen_MessageDeliveryTask(MessageIn message, int id, long timestamp)
    {
        assert message != null;
        this.message = message;
        this.id = id;
        constructionTime = timestamp;
        
        priority = -1;
        installed = false;
    }

    public void run()
    {
        MessagingService.Verb verb = message.verb;
        if (MessagingService.DROPPABLE_VERBS.contains(verb)
            && System.currentTimeMillis() > constructionTime + message.getTimeout())
        {
            MessagingService.instance().incrementDroppedMessages(verb);
            return;
        }

        IVerbHandler verbHandler = MessagingService.instance().getVerbHandler(verb);
        if (verbHandler == null)
        {
            logger.debug("Unknown verb {}", verb);
            return;
        }

        verbHandler.doVerb(message, id);
    }

    /*@Override
    public int compareTo(Chen_MessageDeliveryTask o)
    {
        if (message.getMessageType() == Stage.READ)
        {
          //this -------> READ message
            if (o.message.getMessageType() == Stage.READ)
            {
                //this -------> READ message
                return (int)(o.priority - priority);
            }
            else {
                // o -------> MUTATION message
                return compare_READ_MUTATION(this, o);
            }
        }
        else {
            //this ------> MUTATION message
            if (o.message.getMessageType() == Stage.MUTATION)
            {
              //o ------> MUTATION message
                return (int)(o.priority - priority);
            }
            else {
                // this --------> READ message
                return compare_READ_MUTATION(o, this);
            }
        }
    }*/

    private int compare_READ_MUTATION(Chen_MessageDeliveryTask read_task,
            Chen_MessageDeliveryTask mutation_task)
    {
        if (read_task.priority == mutation_task.priority)
        {
            if (read_task.installed)
            {
                return -1;
            }
            else {
                return 1;
            }
        }
        else {
            return (int)(read_task.priority - mutation_task.priority);
        }
        
    }
    
    //chen add
    public MessagingService.Verb getMessageType()
    {
        return message.verb;
    }
    
    //chen add
    public MessageIn getMessage() {
        return message;
    }
    
    public void setPriority(long priority) {
        this.priority = priority;
    }
    
    public long getconstructionTime() {
        return constructionTime;
    }

    @Override
    public ReadCommand getReadCommand()
    {
        assert (message.payload instanceof ReadCommand);

        return (ReadCommand)message.payload;
    }

    @Override
    public RowMutation getRowMutation()
    {
        assert (message.payload instanceof RowMutation);
        return (RowMutation)message.payload;
    }
    
}