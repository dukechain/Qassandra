package org.apache.cassandra.concurrent.scheduler.policy;

import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;


public class WSJF_policy implements Policy
{
    @Override
    public void setReadPriority(RWTask readTask, List<RWTask> writeTask)
    {
        ///////////////////////////
        
        if (writeTask == null)
        {
            readTask.setPriority(1d);
        }
        else {
            readTask.setPriority(1d);
        }

        
    }
}
