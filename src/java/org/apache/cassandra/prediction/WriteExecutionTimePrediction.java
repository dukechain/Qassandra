package org.apache.cassandra.prediction;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.RowMutation;

public class WriteExecutionTimePrediction 
{
    
    public long time_prediction(byte[] key)
    {
        return BDBStorage.getInstance().getWriteCost(key);
    }

    public long time_prediction(RWTask task)
    {
        RowMutation rw = task.getRowMutation();
        
        ByteBuffer buffer = rw.key();
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        return time_prediction(bytes);
    }
    
    
    public long time_prediction(List<RWTask> tasks)
    {
        RWTask task = tasks.get(tasks.size()-1);
        
        return time_prediction(task);
    }
    
    public void time_save(byte[] key, long cost)
    {
        BDBStorage.getInstance().setWriteCost(key, cost);
    }
    
    public void time_save(RowMutation rm, long cost)
    {
        ByteBuffer buffer = rm.key();
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        time_save(bytes, cost);
    }
}
