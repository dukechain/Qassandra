package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.concurrent.scheduler.TPE.Chen_JMXConfigurableThreadPoolExecutor;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;
import org.apache.cassandra.concurrent.updatemodel.UpdateExecution;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.MessagingService;

/**
 * Hybrid On Demand mechanism
 */
public class HOD_mechanism extends Chen_JMXConfigurableThreadPoolExecutor
{

    public HOD_mechanism(int corePoolSize,
            long keepAliveTime, 
            TimeUnit unit, 
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath,
            BlockingQueue<Runnable> writeQueue, 
            Policy priority_calculate) {
        
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath,
                writeQueue, priority_calculate);     
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) { 
        super.beforeExecute(t, r);
        
        RWTask task = (RWTask) r;
        
        if (task.getMessageType() == MessagingService.Verb.READ)
        {
            ReadCommand rc = task.getReadCommand();
            
            rc.para_wrapper.staleness_deadline = Long.MAX_VALUE;
            
            List<RWTask> writetask = removeWritesonGivenKey(rc.key);
            
            if (writetask != null && !writetask.isEmpty())
            {
                rc.para_wrapper.first_unapplied_time =
                        writetask.get(0).getRowMutation().local_arrival_time;
                
                //writetask.get(writetask.size() - 1).run();
                
                /*for (RWTask rwTask : writetask)
                {
                    rwTask.run();
                }*/
                UpdateExecution.updateexecute(writetask);
                
                rc.para_wrapper.first_unapplied_time = Long.MAX_VALUE;
            }
        }
    }
    

}
