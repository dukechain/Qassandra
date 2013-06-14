package org.apache.cassandra.db;

import org.apache.cassandra.thrift.Agreement_parameters;



public class SchedulerParameter
{
    public long tardiness_deadline;
    public long staleness_deadline;
    
    public long arrival_time;
    
    public double QoS_preference;
    public double query_weight;
    
    public boolean isInstalled;
    public long QC_k;
    public long UC_k;
    
    
    public SchedulerParameter(long tardiness_deadline, long staleness_deadline) {
        this.tardiness_deadline = tardiness_deadline;
        this.staleness_deadline = staleness_deadline;
        
        arrival_time = System.currentTimeMillis();
        
        QoS_preference = 1;
        query_weight = 1;
        
        isInstalled = true;
        QC_k = -1;
        UC_k = -1;
    }
    
    public SchedulerParameter(long tardiness_deadline,
            long staleness_deadline,
            long QoS_preference,
            long query_weight) {
        this.tardiness_deadline = tardiness_deadline;
        this.staleness_deadline = staleness_deadline;
        
        arrival_time = System.currentTimeMillis();
        
        this.QoS_preference = QoS_preference;
        this.query_weight = query_weight;
        
        
        isInstalled = true;
    }
    
    public SchedulerParameter(Agreement_parameters agreement_para) {
        this(agreement_para.tardiness_deadline,
                agreement_para.staleness_deadline,
                agreement_para.QoS_preference,
                agreement_para.query_weight);
    }
}
