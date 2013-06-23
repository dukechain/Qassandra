package org.apache.cassandra.concurrent.scheduler;

import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.db.RowMutation;
import org.apache.cassandra.net.MessagingService;


public abstract class RWTask implements Runnable, Comparable<RWTask>
{
    protected double priority;
    
    @Override
    public int compareTo(RWTask o)
    {
        return (int)(o.priority - priority);
    }

    /*@Override
    public abstract void run();*/
    
    public abstract MessagingService.Verb getMessageType();
    
    public abstract ReadCommand getReadCommand();
    
    public abstract RowMutation getRowMutation();
    
    public void setPriority(double priority) {
        this.priority = priority;
    }


}
