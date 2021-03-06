package org.apache.cassandra.prediction.BDBStorage;

import org.apache.cassandra.prediction.CostData;

import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.DatabaseConfig;

/**
 * Berkeley DB storage for Update
 */
public class WriteBDBStorage extends BDBStorage
{

    @Override
    protected void initdatabase()
    {
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setAllowCreate(true);
        
        myDatabase = myDbEnvironment.openDatabase(null, "WriteDatabase", dbConfig);
        myclassCatalog = new StoredClassCatalog(myDatabase);
        mydataBinding = new SerialBinding(myclassCatalog, CostData.class);
    }

}
