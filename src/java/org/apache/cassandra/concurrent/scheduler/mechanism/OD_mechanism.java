package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.concurrent.scheduler.TPE.Chen_DebuggableThreadPoolExecutor;

import org.apache.cassandra.concurrent.scheduler.policy.Policy;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.Chen_MessageDeliveryTask;
import org.apache.cassandra.net.MessagingService;

public class OD_mechanism extends Chen_DebuggableThreadPoolExecutor
{
   
    

    public OD_mechanism(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            ThreadFactory threadFactory, BlockingQueue<Runnable> writeQueue, Policy priority_calculate)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, 
                writeQueue, priority_calculate);
    }

    protected void beforeExecute(Thread t, Runnable r) { 
        super.beforeExecute(t, r);
        
        Chen_MessageDeliveryTask task = (Chen_MessageDeliveryTask) r;
        
        if (task.getMessageType() == MessagingService.Verb.READ)
        {
            ReadCommand rc = (ReadCommand) task.getMessage().payload;
            
            Runnable writetask = getWriteonGivenKey(rc.key);
            
            if (writetask != null)
            {
                writetask.run();
            }
        }
    }
    

}
