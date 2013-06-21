package org.apache.cassandra.db;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;


import org.apache.cassandra.thrift.Agreement_parameters;



public class SchedulerParameter
{
    //user specification
    public long tardiness_deadline;
    public long staleness_deadline;
    
    public double QoS_preference;
    public double query_weight;
    
    //system behaviour
    public boolean isInstalled = true;
    
    //important timestamp
    public long issue_time = -1;
    public long arrival_time = -1;
    
    public long local_start_time = -1;
    public long local_finished_time = -1;
    
    //execution time estimation
    public long estimated_QC_k = -1;
    public long estimated_UC_k = -1;
    
    //the actual execution time
    public long actual_QC_k = -1;
    public long actual_UC_k = -1;
    
    private static final String Token = ",";
    
    
    public SchedulerParameter(long tardiness_deadline, long staleness_deadline) {
        this.tardiness_deadline = tardiness_deadline;
        this.staleness_deadline = staleness_deadline;
        
        QoS_preference = 1;
        query_weight = 1;
    }
    
    public SchedulerParameter(long tardiness_deadline,
            long staleness_deadline,
            double QoS_preference,
            double query_weight) {
        this.tardiness_deadline = tardiness_deadline;
        this.staleness_deadline = staleness_deadline;
        
        this.QoS_preference = QoS_preference;
        this.query_weight = query_weight;
    }
    
    public SchedulerParameter(Agreement_parameters agreement_para) {
        this(agreement_para.tardiness_deadline,
                agreement_para.staleness_deadline,
                agreement_para.QoS_preference,
                agreement_para.query_weight);
    }
    
    public SchedulerParameter(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, Token);
        
        tardiness_deadline = Long.parseLong(tokenizer.nextToken());
        staleness_deadline = Long.parseLong(tokenizer.nextToken());
        
        QoS_preference = Double.parseDouble(tokenizer.nextToken());
        query_weight = Double.parseDouble(tokenizer.nextToken());
        
        isInstalled = Boolean.parseBoolean(tokenizer.nextToken());
        
        issue_time = Long.parseLong(tokenizer.nextToken());
        arrival_time = Long.parseLong(tokenizer.nextToken());
        
        local_start_time = Long.parseLong(tokenizer.nextToken());
        local_finished_time = Long.parseLong(tokenizer.nextToken());
        
        estimated_QC_k = Long.parseLong(tokenizer.nextToken());
        estimated_UC_k = Long.parseLong(tokenizer.nextToken());
        
        actual_QC_k = Long.parseLong(tokenizer.nextToken());
        actual_UC_k = Long.parseLong(tokenizer.nextToken());      
    }
    
    public SchedulerParameter(ByteBuffer bb) {
        this(toString(bb));
    }
    
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        
        sb.append(tardiness_deadline);
        sb.append(Token);
        sb.append(staleness_deadline);
        sb.append(Token);
        
        sb.append(QoS_preference);
        sb.append(Token);
        sb.append(query_weight);
        sb.append(Token);
        
        sb.append(isInstalled);
        sb.append(Token);
        
        sb.append(issue_time);
        sb.append(Token);
        sb.append(arrival_time);
        sb.append(Token);
        
        sb.append(local_start_time);
        sb.append(Token);
        sb.append(local_finished_time);
        sb.append(Token);
        
        sb.append(estimated_QC_k);
        sb.append(Token);
        sb.append(estimated_UC_k);
        sb.append(Token);
        
        sb.append(actual_QC_k);
        sb.append(Token);
        sb.append(actual_UC_k);
        
        return sb.toString();
    }
    
    public void set_actual_QC_k()
    {
        actual_QC_k = local_finished_time - local_start_time;
    }
    
    public ByteBuffer toByteBuffer()
    {
        return toByteBuffer(toString());
    }
    
    public static String toString(ByteBuffer buffer) 
    {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        
        String str = null;
        try
        {
            str = new String(bytes, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        return str;
     }
    
    public static ByteBuffer toByteBuffer(String str) 
    {
        byte [] array = null;
        try
        {
            array = str.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        return ByteBuffer.wrap(array);
    }
}
