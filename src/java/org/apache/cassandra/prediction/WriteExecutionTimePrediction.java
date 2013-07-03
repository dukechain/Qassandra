package org.apache.cassandra.prediction;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.prediction.BDBStorage.WriteBDBStorage;
import org.apache.cassandra.prediction.BDBStorageSingleton.WriteBDBStorageSingleton;

public class WriteExecutionTimePrediction extends ExecutionTimePrediction
{
    @Override
    public long time_prediction(byte[] key)
    {
 
        long time = 0l;
        
        if (DatabaseDescriptor.getPolicy().equals("FCFS"))
        {
            time = new WriteBDBStorage().getValue(key);
        }
        else 
        {
            time = WriteBDBStorageSingleton.getInstance().getValue(key);
        }
        
        return time;
    }
    
    @Override
    public void time_save(byte[] key, long cost)
    {

        long st = System.currentTimeMillis();
        
        if (DatabaseDescriptor.getPolicy().equals("FCFS"))
        {
            new WriteBDBStorage().setValue(key, cost);
        }
        else 
        {
            WriteBDBStorageSingleton.getInstance().setValue(key, cost);
        }
        
        long en = System.currentTimeMillis();
        
        logger.debug("insert BDB of key="+new String(key)+" is "+(en-st)+" ms");
    }

    @Override
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
    

    public void time_save(RowMutation rm, long cost)
    {
        ByteBuffer buffer = rm.key();
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        time_save(bytes, cost);
    }
}
