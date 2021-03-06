package org.apache.cassandra.prediction;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.prediction.BDBStorage.WriteBDBStorage;
import org.apache.cassandra.prediction.BDBStorageSingleton.WriteBDBStorageSingleton;
import org.apache.cassandra.utils.ByteBufferUtil;

/**
 *  To predict the execution time of Update
 */
public class WriteExecutionTimePrediction extends ExecutionTimePrediction
{
    @Override
    public long time_prediction(byte[] key)
    {
 
        long time = 0l;
        
        if (isBDBTransaction())
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
        
        if (isBDBTransaction())
        {
            new WriteBDBStorage().setValue(key, cost);
        }
        else 
        {
            WriteBDBStorageSingleton.getInstance().setValue(key, cost);
        }
        
        long en = System.currentTimeMillis();
        
        logger.debug("insert BDB of WRITE key="+new String(key)+" is "+(en-st)+" ms");
    }

    @Override
    public long time_prediction(RWTask task)
    {
        RowMutation rw = task.getRowMutation();
        
        ByteBuffer buffer = ByteBufferUtil.clone(rw.key());;
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        return time_prediction(bytes);
    }
    
   
    
    public long time_prediction(List<RWTask> tasks)
    {
        RWTask task = tasks.get(tasks.size()-1);
        
        // n updates
        return time_prediction(task)*tasks.size();
    }
    

    public void time_save(RowMutation rm, long cost)
    {
        ByteBuffer buffer = ByteBufferUtil.clone(rm.key());
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        time_save(bytes, cost);
    }
}
