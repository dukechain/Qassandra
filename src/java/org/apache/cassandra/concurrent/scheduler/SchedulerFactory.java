package org.apache.cassandra.concurrent.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.TPE.Chen_JMXConfigurableThreadPoolExecutor;
import org.apache.cassandra.concurrent.scheduler.mechanism.OD_mechanism;
import org.apache.cassandra.concurrent.scheduler.policy.EDF_policy;
import org.apache.cassandra.concurrent.scheduler.policy.FCFS_policy;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;



public class SchedulerFactory
{
    
    public static Chen_JMXConfigurableThreadPoolExecutor createScheduler(
            String mechanism_type,
            String policy_type,
            int corePoolSize, 
            long keepAliveTime, 
            TimeUnit unit, 
            BlockingQueue<Runnable> workQueue, 
            NamedThreadFactory threadFactory,
            String jmxPath,
            BlockingQueue<Runnable> writeQueue) {
        
        Policy policy = getPolicy(policy_type);
        
        
        
        if (mechanism_type.equals("OD"))
        {
            return new OD_mechanism(corePoolSize, keepAliveTime, unit, workQueue, 
                    threadFactory,
                    jmxPath, writeQueue, policy); 
        }
        else if (mechanism_type.equals("HOD")) {
            return null;
        } else if (mechanism_type.equals("FIT")) {
            return null;
        }
       
        return null;
    }

    private static Policy getPolicy(String policy_type)
    {
        if (policy_type.equals("FCFS"))
            return new FCFS_policy();
        else if (policy_type.equals("EDF"))
            return new EDF_policy();
        return null;
    }
}
