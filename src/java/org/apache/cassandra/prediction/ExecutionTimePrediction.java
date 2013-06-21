package org.apache.cassandra.prediction;

import org.apache.cassandra.concurrent.scheduler.RWTask;

public interface ExecutionTimePrediction
{
    public long time_prediction(RWTask task);
}
