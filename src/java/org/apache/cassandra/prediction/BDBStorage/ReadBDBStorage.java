package org.apache.cassandra.prediction.BDBStorage;

import org.apache.cassandra.prediction.CostData;

import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.DatabaseConfig;

/**
 *  Berkeley DB storage for Query
 */
public class ReadBDBStorage extends BDBStorage
{

    public ReadBDBStorage()
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

}
