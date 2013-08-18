package org.apache.cassandra.concurrent.scheduler.policy;

import java.util.List;

import org.apache.cassandra.concurrent.scheduler.RWTask;
import org.apache.cassandra.db.ReadCommand;
import org.apache.cassandra.prediction.ReadExecutionTimePrediction;

public class Density_policy implements Policy
{

    @Override
    public void setReadPriority(RWTask readTask, List<RWTask> writeTask, long tau)
    {
        ReadCommand read = readTask.getReadCommand();
        
        double alpha = read.para_wrapper.QoS_preference;
        double W_i = read.para_wrapper.query_weight;
        
        read.para_wrapper.setTardinessDeadline();
        
        if (read.para_wrapper.estimated_QC_k == -1)
        {
            read.para_wrapper.estimated_QC_k = new 
                    ReadExecutionTimePrediction().time_prediction(readTask);
        }
        
        double QC_k = read.para_wrapper.estimated_QC_k;
        double UC_k = read.para_wrapper.estimated_UC_k;
        
       
        
        if (read.para_wrapper.isInstalled || writeTask == null)
        {
            double density_factor = tau + QC_k + UC_k 
                    - read.para_wrapper.tardiness_deadline;
            
            if (density_factor<=0)
            {
                density_factor = 0;
            }
            
            double V_I = alpha * W_i* density_factor/(QC_k + UC_k);
            
            readTask.setPriority(V_I);
        }
        else {
            
            double density_factor = tau + QC_k
                    - read.para_wrapper.tardiness_deadline;
            
            if (density_factor<=0)
            {
                density_factor = 0;
            }
            
            
            double W_im = 0;
            
            if (read.para_wrapper.tardiness_deadline <=
                    read.para_wrapper.staleness_deadline)
            {
                W_im = alpha * W_i * density_factor;
            }
            else {
                W_im = (1-alpha) * W_i * density_factor;
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
