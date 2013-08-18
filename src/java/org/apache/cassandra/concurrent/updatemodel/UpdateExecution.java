package org.apache.cassandra.concurrent.updatemodel;

import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.config.DatabaseDescriptor;

public class UpdateExecution
{
    public static void updateexecute(List<RWTask> writetask)
    {
        if (DatabaseDescriptor.getUpdateModel().equals("state-transfer"))
        {
            RWTask task = writetask.get(writetask.size()-1);
            
            task.run();
        }
        else {
            for (RWTask rwTask : writetask)
            {
                rwTask.run();
            }
        }
    }
}
