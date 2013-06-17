package org.apache.cassandra.concurrent.scheduler.policy;

import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;


public class WSJF_policy implements Policy
{
    @Override
    public void setReadPriority(RWTask readTask, List<RWTask> writeTask, long tau)
    {        
        ReadCommand read = readTask.getReadCommand();
        
        double alpha = read.para_wrapper.QoS_preference;
        double W_i = read.para_wrapper.query_weight;
        
        double QC_k = read.para_wrapper.estimated_QC_k;
        double UC_k = read.para_wrapper.estimated_UC_k;
        
        if (read.para_wrapper.isInstalled || writeTask == null)
        {
            double V_I = alpha * W_i /(QC_k + UC_k);
            
            readTask.setPriority(V_I);
        }
        else {
            double W_im = 0;
            
            if (read.para_wrapper.tardiness_deadline <=
                    read.para_wrapper.staleness_deadline)
            {
                W_im = alpha * W_i;
            }
            else {
                W_im = (1-alpha) * W_i;
            }
            
            double V_S = 0d;
            
            if (tau <= read.para_wrapper.tardiness_deadline)
            {
                V_S = W_im / QC_k;
            }
            else {
                V_S = W_i / QC_k;
            }

            readTask.setPriority(V_S);
        }
        
    }
}
