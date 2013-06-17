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
import org.apache.cassandra.prediction.ExecutionTimePrediction;
import org.apache.cassandra.prediction.ReadExecutionTimePrediction;


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
                
                if (writetask != null)
                {
                    writetask.get(writetask.size()-1).run();
                }
            }
        }
    }
    
    
    @Override
    protected void resetPriority(long tau) {
        for (Runnable r : getQueue())
        {            
            ExecutionTimePrediction prediction = new ReadExecutionTimePrediction();
            
            RWTask readtask = (RWTask) r;
            ReadCommand read = readtask.getReadCommand();
            
            read.para_wrapper.estimated_QC_k = prediction.time_prediction(readtask);
            
            //read.para_wrapper.UC_k = prediction.time_prediction(getWritesonGivenKey((RWTask)w));
            
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
