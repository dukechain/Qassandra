package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.concurrent.scheduler.TPE.Chen_JMXConfigurableThreadPoolExecutor;

import org.apache.cassandra.concurrent.scheduler.policy.Policy;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.Chen_MessageDeliveryTask;
import org.apache.cassandra.net.MessagingService;

public class OD_mechanism extends Chen_JMXConfigurableThreadPoolExecutor
{
    public OD_mechanism(int corePoolSize,
            long keepAliveTime, 
            TimeUnit unit, 
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath,
            BlockingQueue<Runnable> writeQueue, 
            Policy priority_calculate)
    {
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath,
                writeQueue, priority_calculate);
    }

    protected void beforeExecute(Thread t, Runnable r) { 
        super.beforeExecute(t, r);
        
        RWTask task = (RWTask) r;
        
        if (task.getMessageType() == MessagingService.Verb.READ)
        {
            ReadCommand rc = task.getReadCommand();
            
            Runnable writetask = getWriteonGivenKey(rc.key);
            
            if (writetask != null)
            {
                writetask.run();
            }
        }
    }
    

}
