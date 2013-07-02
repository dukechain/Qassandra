package org.apache.cassandra.prediction;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;

import java.io.File;
import java.io.UnsupportedEncodingException;

import org.apache.cassandra.config.Config;
import org.apache.cassandra.config.DatabaseDescriptor;



public class BDBStorage
{

 // Open the environment. Allow it to be created if it does not 
 // already exist.
    
    Environment myDbEnvironment = null;
    
    Database readDatabase = null;
    StoredClassCatalog readclassCatalog; 
    EntryBinding readdataBinding;
    
    
    Database writeDatabase = null;
    StoredClassCatalog writeclassCatalog; 
    EntryBinding writedataBinding;
    
    
    private volatile static BDBStorage singleton;
    
    public static synchronized BDBStorage getInstance()
    {
        if (singleton == null)
        {
            synchronized (BDBStorage.class)
            {
                if (singleton == null)
                {
                    singleton = new BDBStorage();
                }
            }  
        }
        
        return singleton;
    }
    
    private BDBStorage() 
    {
         EnvironmentConfig envConfig = new EnvironmentConfig();
         envConfig.setAllowCreate(true);
         
         myDbEnvironment = new Environment(new File(DatabaseDescriptor.getBerkeleyDB_path()), envConfig);

         DatabaseConfig dbConfig = new DatabaseConfig();
         dbConfig.setAllowCreate(true);
         readDatabase = myDbEnvironment.openDatabase(null, "ReadDatabase", dbConfig);
         readclassCatalog = new StoredClassCatalog(readDatabase);
         readdataBinding = new SerialBinding(readclassCatalog, CostData.class);
         
         writeDatabase = myDbEnvironment.openDatabase(null, "WriteDatabase", dbConfig);
         writeclassCatalog = new StoredClassCatalog(writeDatabase);
         writedataBinding = new SerialBinding(writeclassCatalog, CostData.class);
         
    }
    
    
    public long getWriteCost(byte[] key)
    {
        long cost = 0;
        
        try {
            DatabaseEntry theKey = new DatabaseEntry(key);
            DatabaseEntry theData = new DatabaseEntry();
            
            writeDatabase.get(null, theKey, theData, LockMode.DEFAULT);
            // Recreate the MyData object from the retrieved DatabaseEntry using
            // 根据存储的类信息还原数据
         
            CostData retrievedData=(CostData)writedataBinding.entryToObject(theData);
            
            cost = retrievedData.getLong();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return cost;
    }
    
    
    public void setWriteCost(byte[] key, long cost) 
    {
        DatabaseEntry theKey;
        try
        {
            theKey = new DatabaseEntry(key);
            
            // 向DatabaseEntry里写数据
            CostData data2Store = new CostData();
            data2Store.setLong(cost);
    
            DatabaseEntry theData = new DatabaseEntry();
    
            writedataBinding.objectToEntry(data2Store, theData);
    
            writeDatabase.put(null, theKey, theData);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public long getReadCost(byte[] key)
    {
        long cost = 0;
        
        try {
            DatabaseEntry theKey = new DatabaseEntry(key);
            DatabaseEntry theData = new DatabaseEntry();
            
            readDatabase.get(null, theKey, theData, LockMode.DEFAULT);
            // Recreate the MyData object from the retrieved DatabaseEntry using
            // 根据存储的类信息还原数据
         
            CostData retrievedData=(CostData)readdataBinding.entryToObject(theData);
            
            cost = retrievedData.getLong();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return cost;
    }
    

    
    public void setReadCost(byte[] key, long cost) 
    {
        DatabaseEntry theKey;
        try
        {
            theKey = new DatabaseEntry(key);
            
            // 向DatabaseEntry里写数据
            CostData data2Store = new CostData();
            data2Store.setLong(cost);
    
            DatabaseEntry theData = new DatabaseEntry();
    
            readdataBinding.objectToEntry(data2Store, theData);
    
            readDatabase.put(null, theKey, theData);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) 
    {
        BDBStorage store = BDBStorage.getInstance();
        
        //store.setValue("001", 25);
        
        //System.out.println(store.getValue("001"));
    }
}
