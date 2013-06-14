package org.apache.cassandra.concurrent.scheduler.policy;



import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;


public class FCFS_policy implements Policy
{

    @Override
    public void setReadPriority(RWTask readTask, List<RWTask> writeTask, long tau)
    {
        ReadCommand rc = readTask.getReadCommand();
        
        long arrival_time = rc.para_wrapper.arrival_time;
        
        readTask.setPriority(1d/arrival_time);
        
    }
}
