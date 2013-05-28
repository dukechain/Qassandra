package org.apache.cassandra.concurrent.scheduler.policy;



import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;


public class FCFS_policy implements Policy
{

    @Override
    public void setReadPriority(RWTask task)
    {
        ReadCommand rc = task.getReadCommand();
        
        long arrival_time = rc.para_wrapper.arrival_time;
        
        task.setPriority(1d/arrival_time);
        
    }
}
