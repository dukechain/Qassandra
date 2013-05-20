package org.apache.cassandra.concurrent.scheduler.policy;

import org.apache.cassandra.net.Chen_MessageDeliveryTask;

public interface Policy
{

    public void setReadPriority(Chen_MessageDeliveryTask task);
}
