package org.apache.cassandra.concurrent.scheduler.policy;



import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;

/**
 * 
 * First Come First Served policy
 */
public class FCFS_policy implements Policy
{

    @Override
    public void setReadPriority(RWTask readTask, List<RWTask> writeTask, long tau)
    {
        ReadCommand rc = readTask.getReadCommand();
        
        rc.para_wrapper.setTardinessDeadline();
        
        long arrival_time = rc.para_wrapper.local_arrival_time;
        
        if (arrival_time != 0)
        {
            readTask.setPriority(1d/(double)arrival_time);
        }
        else {
            readTask.setPriority(0d);
        }
        
        
    }
}
