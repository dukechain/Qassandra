package org.apache.cassandra.concurrent.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.Chen_MessageDeliveryTask;
import org.apache.cassandra.net.MessagingService;

public class OnDemand_Scheduler extends Chen_ThreadPoolExecutor
{

    public OnDemand_Scheduler(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            BlockingQueue<Runnable> writeQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, writeQueue);
        // TODO Auto-generated constructor stub
    }

    public OnDemand_Scheduler(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            ThreadFactory threadFactory, BlockingQueue<Runnable> writeQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, writeQueue);
        // TODO Auto-generated constructor stub
    }

    public OnDemand_Scheduler(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            Chen_RejectedExecutionHandler handler, BlockingQueue<Runnable> writeQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler, writeQueue);
        // TODO Auto-generated constructor stub
    }

    public OnDemand_Scheduler(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            ThreadFactory threadFactory, Chen_RejectedExecutionHandler handler, BlockingQueue<Runnable> writeQueue)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler, writeQueue);
        // TODO Auto-generated constructor stub
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
