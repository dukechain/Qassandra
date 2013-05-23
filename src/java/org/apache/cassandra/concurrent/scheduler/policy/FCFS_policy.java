package org.apache.cassandra.concurrent.scheduler.policy;


import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.Chen_MessageDeliveryTask;

public class FCFS_policy implements Policy
{

    @Override
    public void setReadPriority(ReadCommand rc)
    {
        /*long priority = task.getconstructionTime();
        
        task.setPriority(priority);*/
        
        
    }
}
