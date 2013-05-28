package org.apache.cassandra.concurrent.scheduler.policy;


import org.apache.cassandra.concurrent.scheduler.RWTask;

public interface Policy
{

    public void setReadPriority(RWTask task);
}
