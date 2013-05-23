package org.apache.cassandra.concurrent.scheduler.policy;

import org.apache.cassandra.db.ReadCommand;

public interface Policy
{

    public void setReadPriority(ReadCommand rc);
}
