package org.apache.cassandra.prediction.BDBStorageSingleton;

import java.io.File;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.prediction.CostData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;

public abstract class BDBStorageSingleton
{

    private static final Logger logger = LoggerFactory.getLogger(BDBStorageSingleton.class);
    
    protected volatile static BDBStorageSingleton singleton;
    
    Environment myDbEnvironment = null;
    
    Database myDatabase = null;
    StoredClassCatalog myclassCatalog; 
    EntryBinding mydataBinding;
    
    
    
    public BDBStorageSingleton() 
    {
         EnvironmentConfig envConfig = new EnvironmentConfig();
         
         //envConfig.setTransactional(true);
         envConfig.setAllowCreate(true);
         //envConfig.setDurability(Durability.COMMIT_WRITE_NO_SYNC);
         
         //String path = "/home/xuchen/testcassandra/BDB";
         myDbEnvironment = new Environment(new File(DatabaseDescriptor.getBerkeleyDB_path()), envConfig);

        // myDbEnvironment = new Environment(new File(path), envConfig);
         
         long st = System.currentTimeMillis();
         initdatabase();
         long en = System.currentTimeMillis();

         logger.debug("Database for initialization "+(en-st)+" ms");
    }

    protected abstract void initdatabase();
    
    
    private void cleanup()
    {
        
    }
    
    public long getValue(byte[] key)
    {
        long cost = 0;

        try {
            DatabaseEntry theKey = new DatabaseEntry(key);
            DatabaseEntry theData = new DatabaseEntry();
            
            long st = System.currentTimeMillis();
            myDatabase.get(null, theKey, theData, LockMode.DEFAULT);
            // Recreate the MyData object from the retrieved DatabaseEntry using
            // 根据存储的类信息还原数据
            
            CostData retrievedData=(CostData)mydataBinding.entryToObject(theData);
            long en = System.currentTimeMillis();
            
            if (retrievedData == null)
            {
                logger.error("we can not find READ cost for key="+new String(key));
            }
            else {
                logger.debug("GET the READ cost for key="+new String(key)
                    +" for "+(en-st)+"ms");
            }
            
            cost = retrievedData.getLong();
            
            cleanup();
        }
        catch(NullPointerException n) {
            logger.error("we can not find READ cost for key="+new String(key));
        }
        catch(Exception e) {
            logger.error(e.toString());
        }
        
        return cost;
    }
    

    public void setValue(byte[] key, long cost) 
    {        
        DatabaseEntry theKey;
        try
        {
            theKey = new DatabaseEntry(key);
            
            // 向DatabaseEntry里写数据
            CostData data2Store = new CostData();
            data2Store.setLong(cost);
    
            DatabaseEntry theData = new DatabaseEntry();
    
            mydataBinding.objectToEntry(data2Store, theData);
    
            myDatabase.put(null, theKey, theData);
            
            logger.debug("Saving the READ cost for key="+new String(key));
            
            cleanup();
        }
        catch (Exception e)
        {
            logger.error(e.toString());
        }
        
        
    }
    
    
}
