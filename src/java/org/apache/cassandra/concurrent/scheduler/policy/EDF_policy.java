package org.apache.cassandra.concurrent.scheduler.policy;

import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.net.Chen_MessageDeliveryTask;

public class EDF_policy implements Policy
{

    @Override
    public void setReadPriority(ReadCommand rc)
    {
        /*ReadCommand rc = (ReadCommand) task.getMessage().payload;
        
        long priority = rc.tardiness_deadline;
        
        task.setPriority(priority);*/
    }

}
