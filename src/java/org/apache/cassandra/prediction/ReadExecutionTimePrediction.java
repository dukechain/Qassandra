package org.apache.cassandra.prediction;

import java.nio.ByteBuffer;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;



public class ReadExecutionTimePrediction
{
    public long time_prediction(byte[] key)
    {
        return BDBStorage.getInstance().getReadCost(key);
    }

    public long time_prediction(RWTask task)
    {
        ReadCommand rc = task.getReadCommand();
        
        ByteBuffer buffer = rc.key;
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        return time_prediction(bytes);
    }
    
    
    public void time_save(byte[] key, long cost)
    {
        BDBStorage.getInstance().setReadCost(key, cost);
    }
    
    public void time_save(ReadCommand rc, long cost)
    {
        ByteBuffer buffer = rc.key;
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        time_save(bytes, cost);
    }
}
