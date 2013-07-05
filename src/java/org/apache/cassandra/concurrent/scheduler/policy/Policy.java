package org.apache.cassandra.concurrent.scheduler.policy;


import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;


public interface Policy
{

    public void setReadPriority(RWTask readTask, List<RWTask> writeTasks, long current_time);
}
