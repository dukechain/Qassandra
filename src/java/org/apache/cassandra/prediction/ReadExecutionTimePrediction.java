package org.apache.cassandra.prediction;

import java.nio.ByteBuffer;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.prediction.BDBStorage.ReadBDBStorage;
import org.apache.cassandra.prediction.BDBStorageSingleton.ReadBDBStorageSingleton;


/**
 * To predict the execution time of Query
 */
public class ReadExecutionTimePrediction extends ExecutionTimePrediction
{

    @Override
    public long time_prediction(byte[] key)
    {
        long st = System.currentTimeMillis();
        
        long time = 0l;
        
        if (isBDBTransaction())
        {
            time = new ReadBDBStorage().getValue(key);
        }
        else 
        {
            time = ReadBDBStorageSingleton.getInstance().getValue(key);
        }
        
        long en = System.currentTimeMillis();
        
        logger.debug("retrieve BDB of key="+new String(key)+" is "+(en-st)+" ms");
        
        return time;
    }
    
    @Override
    public void time_save(byte[] key, long cost)
    {
        long st = System.currentTimeMillis();
        
        if (isBDBTransaction())
        {
            new ReadBDBStorage().setValue(key, cost);
        }
        else 
        {
            ReadBDBStorageSingleton.getInstance().setValue(key, cost);
        }
        
        long en = System.currentTimeMillis();
        
        logger.debug("insert BDB of key="+new String(key)+" is "+(en-st)+" ms");
    }

    @Override
    public long time_prediction(RWTask task)
    {
        ReadCommand rc = task.getReadCommand();
        
        ByteBuffer buffer = rc.key.duplicate();
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        return time_prediction(bytes);
    }
    
    
    
    public void time_save(ReadCommand rc, long cost)
    {
        ByteBuffer buffer = rc.key.duplicate();
        
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        time_save(bytes, cost);
    }
}
