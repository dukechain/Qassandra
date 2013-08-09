package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.concurrent.scheduler.TPE.Chen_JMXConfigurableThreadPoolExecutor;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.MessagingService;
import org.apache.cassandra.prediction.ReadExecutionTimePrediction;
import org.apache.cassandra.prediction.WriteExecutionTimePrediction;

/**
 * Freshness/Tardiness mechanism
 */
public class FIT_mechanism extends Chen_JMXConfigurableThreadPoolExecutor
{

    public FIT_mechanism(int corePoolSize,
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
            
            if (rc.para_wrapper.isInstalled)
            {
                
                
                //remove 
                List<RWTask> writetask = removeWritesonGivenKey(rc.key);
                
                if (writetask != null && !writetask.isEmpty())
                {
                    long st = System.currentTimeMillis();
                    
                    for (RWTask rwTask : writetask)
                    {
                        rwTask.run();
                    }
                    
                    long en = System.currentTimeMillis();
                    
                    rc.para_wrapper.actual_UC_k = en-st;
                }
                
                rc.para_wrapper.first_unapplied_time = Long.MAX_VALUE;
                rc.para_wrapper.staleness_deadline = Long.MAX_VALUE;
            }
            else {
                List<RWTask> writetask = removeWritesonGivenKey(rc.key);
                
                if (writetask != null && !writetask.isEmpty())
                {
                    rc.para_wrapper.first_unapplied_time =
                            writetask.get(0).getRowMutation().local_arrival_time;
                    rc.para_wrapper.setStalenessDeadline();
                }
            }
            
        }
    }
    
    
    @Override
    protected void resetPriority(long tau) {
        ReadExecutionTimePrediction readPredict = new ReadExecutionTimePrediction();
        WriteExecutionTimePrediction writePredict = new WriteExecutionTimePrediction();
        
        for (Runnable r : getQueue())
        {            
            RWTask readtask = (RWTask) r;
            ReadCommand read = readtask.getReadCommand();
            
            
            read.para_wrapper.setTardinessDeadline();
            
            if (read.para_wrapper.estimated_QC_k == -1)
            {
                read.para_wrapper.estimated_QC_k = readPredict.time_prediction(readtask);
            }
            
            
            List<RWTask> pendingUpdate = getWritesonGivenKey((RWTask)readtask);
            
            
            if (pendingUpdate.isEmpty())
            {
                read.para_wrapper.estimated_UC_k = 0;
            }
            else {
                read.para_wrapper.estimated_UC_k = 
                        writePredict.time_prediction(pendingUpdate);
                
                long first_unapplied_time = 
                        pendingUpdate.get(0).getRowMutation().local_arrival_time;
                
                read.para_wrapper.setFirst_unapplied_time(first_unapplied_time);
                read.para_wrapper.setStalenessDeadline();
            }
                        
            
            double Ps = penalty_skipping_update(read, tau);
            double Pi = penalty_installing_update(read, tau);
            
            if (Ps >= Pi)
            {
                read.para_wrapper.isInstalled = true;
            }
            else {
                read.para_wrapper.isInstalled = false;
            }
            
            priority_calculate.setReadPriority(readtask, 
                    getWritesonGivenKey(readtask),
                    tau);
        }
    }

    protected double penalty_skipping_update(ReadCommand read, long tau)
    {
        double Ps = 0d;
        
        long QC_k = read.para_wrapper.estimated_QC_k;
        
        long tardiness = tau + QC_k - read.para_wrapper.tardiness_deadline;
        tardiness = (tardiness > 0)? tardiness: 0;
        
        long staleness = tau + QC_k - read.para_wrapper.staleness_deadline;
        staleness = (staleness > 0)? staleness: 0;
        
        //...........
        staleness = (long)(staleness/1000d);
        //...........
        
        double alpha_i = read.para_wrapper.QoS_preference;
        double Wi = read.para_wrapper.query_weight;
        
        Ps = tardiness * alpha_i * Wi + staleness * (1 - alpha_i) * Wi;
        
        return Ps;
    }
    
    protected double penalty_installing_update(ReadCommand read, long tau)
    {
        double Pi = 0d;
        
        long QC_k = read.para_wrapper.estimated_QC_k;
        long UC_k = read.para_wrapper.estimated_UC_k;
        
        long tardiness = tau + QC_k + UC_k - read.para_wrapper.tardiness_deadline;
        tardiness = (tardiness > 0)? tardiness: 0;
        
        double alpha_i = read.para_wrapper.QoS_preference;
        double Wi = read.para_wrapper.query_weight;
        
        Pi = tardiness * alpha_i * Wi;
        
        return Pi;
    }

}
