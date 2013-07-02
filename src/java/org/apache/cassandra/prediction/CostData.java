package org.apache.cassandra.prediction;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CostData implements Serializable
{
    private long longData;

    private String description;
    
    CostData() {
        longData = 0;
        description = null;
    }
    
    public void setLong(long data) {
        longData = data;
    }

    public void setDescription(String data) {
        description = data;
    }
    
    public long getLong() {
        return longData;
    }
    
    
    public String getDescription() {
        return description;
    }
}
