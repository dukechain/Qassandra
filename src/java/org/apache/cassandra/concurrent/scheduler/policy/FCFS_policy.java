package org.apache.cassandra.concurrent.scheduler.policy;


import org.apache.cassandra.net.Chen_MessageDeliveryTask;

public class FCFS_policy implements Policy
{

    @Override
    public void setReadPriority(Chen_MessageDeliveryTask task)
    {
        long priority = task.getconstructionTime();
        
        task.setPriority(priority);
        
    }
}
