package org.apache.cassandra.concurrent.scheduler;

import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.net.MessageIn;

public class IsUserOperation
{
    public static boolean isUserMessage(MessageIn message)
    {        
        if (message.payload instanceof RowMutation)
        {
            return isUserRowMutation((RowMutation)message.payload);
        }
        
        if (message.payload instanceof ReadCommand)
        {
            return isUserReadCommand((ReadCommand)message.payload);
        }
        
        return false;
    }
    
    public static boolean isUserRowMutation(RowMutation rm)
    {
        String keyspace = rm.getTable();
        return isUserKeyspace(keyspace);
    }
    
    public static boolean isUserReadCommand(ReadCommand rc)
    {
        String keyspace = rc.getKeyspace();
        return isUserKeyspace(keyspace);
    }
    
    public static boolean isUserKeyspace(String keyspace)
    {
        if (keyspace.equals("system")
                ||keyspace.equals("system_auth")
                ||keyspace.equals("system_traces"))
        {
            return false;
        }
        
        return true;
    }
}
