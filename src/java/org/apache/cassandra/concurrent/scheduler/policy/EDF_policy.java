package org.apache.cassandra.concurrent.scheduler.policy;

import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;


/**
 * 
 * Earliest Deadline First policy
 */
public class EDF_policy implements Policy
{

    @Override
    public void setReadPriority(RWTask task, List<RWTask> writeTask, long tau)
    {
        ReadCommand rc = task.getReadCommand();
        
        long tardiness_deadline = rc.para_wrapper.tardiness_deadline;
        
        task.setPriority(1d/tardiness_deadline);
    }

}
