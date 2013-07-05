package org.apache.cassandra.prediction;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To predict the execution time 
 */
public abstract class ExecutionTimePrediction
{
    protected static final Logger logger = LoggerFactory.getLogger(
            ExecutionTimePrediction.class);
    
    public abstract long time_prediction(byte[] key);
    
    public abstract long time_prediction(RWTask task);
    
    public abstract void time_save(byte[] key, long cost);
    
    /**
     * 
     * whether to control Berkeley DB in Transaction manner
     * @return
     */
    public boolean isBDBTransaction()
    {
        if (DatabaseDescriptor.getPolicy().equals("FCFS"))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
