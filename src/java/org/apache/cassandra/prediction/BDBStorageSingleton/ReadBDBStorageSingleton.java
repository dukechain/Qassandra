package org.apache.cassandra.prediction.BDBStorageSingleton;

import org.apache.cassandra.prediction.CostData;

import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.DatabaseConfig;

public class ReadBDBStorageSingleton extends BDBStorageSingleton
{ 
    private ReadBDBStorageSingleton()
    {
        super();
    }
    
    @Override
    protected void initdatabase()
    {
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setAllowCreate(true);
        
        myDatabase = myDbEnvironment.openDatabase(null, "ReadDatabase", dbConfig);
        myclassCatalog = new StoredClassCatalog(myDatabase);
        mydataBinding = new SerialBinding(myclassCatalog, CostData.class);
    }

    public static synchronized BDBStorageSingleton getInstance()
    {
        if (singleton == null)
        {
            synchronized (BDBStorageSingleton.class)
            {
                if (singleton == null)
                {
                    singleton = new ReadBDBStorageSingleton();
                }
            }  
        }
        
        return singleton;
    }
}
