package org.apache.cassandra.db;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;


import org.apache.cassandra.io.IVersionedSerializer;
import org.apache.cassandra.thrift.Agreement_parameters;

/**
 * The parameters for scheduler and it could be employed to evaluate the penalty
 */
public class SchedulerParameter
{
    public static final Serializer serializer = new Serializer();
    
    //user specification
    public long tardiness_tolerance;
    public long staleness_tolerance;
    
    public long tardiness_deadline = -1;
    public long staleness_deadline = Long.MAX_VALUE;
    
    public double QoS_preference;
    public double query_weight;
    
    //system behaviour
    public boolean isInstalled = true;
    
    //important timestamp
    public long client_issue_time = -1;
    public long client_finished_time = -1;
    public long client_latency = -1;
    
    public long local_arrival_time = -1;
    public long local_start_time = -1;
    public long local_finished_time = -1;
    
    //execution time estimation
    public long estimated_QC_k = -1;
    public long estimated_UC_k = -1;
    
    //the actual execution time
    public long actual_QC_k = -1;
    public long actual_UC_k = -1;
    
    
    public long first_unapplied_time = Long.MAX_VALUE;
    
    private static final String Token = ",";
    
    public void setTardinessDeadline() {
        if (tardiness_deadline == -1)
        {
            tardiness_deadline = local_arrival_time + tardiness_tolerance;
        }
    }
    
    public void setFirst_unapplied_time(long first_unapplied_time) {
       this.first_unapplied_time = first_unapplied_time;
    }
    
    public void setStalenessDeadline() {
        if (first_unapplied_time != Long.MAX_VALUE)
        {
            staleness_deadline = first_unapplied_time + staleness_tolerance;
        }
    }
    
    
    public SchedulerParameter() {
        
    }
    
    
    public SchedulerParameter(long tardiness_tolerance, long staleness_tolerance) {
        this.tardiness_tolerance = tardiness_tolerance;
        this.staleness_tolerance = staleness_tolerance;
        
        QoS_preference = 1;
        query_weight = 1;
    }
    
    public SchedulerParameter(long tardiness_tolerance,
            long staleness_tolerance,
            double QoS_preference,
            double query_weight) {
        this.tardiness_tolerance = tardiness_tolerance;
        this.staleness_tolerance = staleness_tolerance;
        
        this.QoS_preference = QoS_preference;
        this.query_weight = query_weight;
    }
    
    public SchedulerParameter(Agreement_parameters agreement_para) {
        this(agreement_para.latency_bound,
                agreement_para.staleness_bound,
                agreement_para.QoS_preference,
                agreement_para.query_weight);
    }
    
    public SchedulerParameter(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, Token);
        
        tardiness_tolerance = Long.parseLong(tokenizer.nextToken());
        staleness_tolerance = Long.parseLong(tokenizer.nextToken());
        
        tardiness_deadline = Long.parseLong(tokenizer.nextToken());
        staleness_deadline = Long.parseLong(tokenizer.nextToken());
        
        QoS_preference = Double.parseDouble(tokenizer.nextToken());
        query_weight = Double.parseDouble(tokenizer.nextToken());
        
        isInstalled = Boolean.parseBoolean(tokenizer.nextToken());
        
        client_issue_time = Long.parseLong(tokenizer.nextToken());
        client_finished_time = Long.parseLong(tokenizer.nextToken());
        client_latency = Long.parseLong(tokenizer.nextToken());
        
        local_arrival_time = Long.parseLong(tokenizer.nextToken());
        local_start_time = Long.parseLong(tokenizer.nextToken());
        local_finished_time = Long.parseLong(tokenizer.nextToken());
        
        
        estimated_QC_k = Long.parseLong(tokenizer.nextToken());
        estimated_UC_k = Long.parseLong(tokenizer.nextToken());
        
        actual_QC_k = Long.parseLong(tokenizer.nextToken());
        actual_UC_k = Long.parseLong(tokenizer.nextToken());      
        
        first_unapplied_time = Long.parseLong(tokenizer.nextToken());
    }
    
    public SchedulerParameter(ByteBuffer bb) {
        this(toString(bb));
    }
    
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        
        sb.append(tardiness_tolerance);
        sb.append(Token);
        sb.append(staleness_tolerance);
        sb.append(Token);
        
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
        
        sb.append(client_issue_time);
        sb.append(Token);
        sb.append(client_finished_time);
        sb.append(Token);
        sb.append(client_latency);
        sb.append(Token);
        
        sb.append(local_arrival_time);
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
        sb.append(Token);
        
        sb.append(first_unapplied_time);
        
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
    
    public static class Serializer implements IVersionedSerializer<SchedulerParameter>
    {

        @Override
        public void serialize(SchedulerParameter t, DataOutput out, int version) throws IOException
        {
            out.writeLong(t.tardiness_tolerance);
            out.writeLong(t.staleness_tolerance);
            
            out.writeLong(t.tardiness_deadline);
            out.writeLong(t.staleness_deadline);
            
            out.writeDouble(t.QoS_preference);
            out.writeDouble(t.query_weight);
            
            //system behaviour
            out.writeBoolean(t.isInstalled);
            
            //important timestamp
            out.writeLong(t.client_issue_time);
            out.writeLong(t.client_finished_time);
            out.writeLong(t.client_latency);
            
            out.writeLong(t.local_arrival_time);
            out.writeLong(t.local_start_time);
            out.writeLong(t.local_finished_time);
            
            //execution time estimation
            out.writeLong(t.estimated_QC_k);
            out.writeLong(t.estimated_UC_k);
            
            //the actual execution time
            out.writeLong(t.actual_QC_k);
            out.writeLong(t.actual_UC_k);
            
            
            out.writeLong(t.first_unapplied_time);
            
        }

        @Override
        public SchedulerParameter deserialize(DataInput in, int version) throws IOException
        {
            SchedulerParameter sp = new SchedulerParameter();
            
            sp.tardiness_tolerance = in.readLong();
            sp.staleness_tolerance = in.readLong();
            
            sp.tardiness_deadline = in.readLong();
            sp.staleness_deadline = in.readLong();
            
            sp.QoS_preference = in.readDouble();
            sp.query_weight = in.readDouble();
            
            //system behaviour
            sp.isInstalled = in.readBoolean();
            
            //important timestamp
            sp.client_issue_time = in.readLong();
            sp.client_finished_time = in.readLong();
            sp.client_latency = in.readLong();
            
            sp.local_arrival_time = in.readLong();
            sp.local_start_time = in.readLong();
            sp.local_finished_time = in.readLong();
            
            //execution time estimation
            sp.estimated_QC_k = in.readLong();
            sp.estimated_UC_k = in.readLong();
            
            //the actual execution time
            sp.actual_QC_k = in.readLong();
            sp.actual_UC_k = in.readLong();
            
            
            sp.first_unapplied_time = in.readLong();
            
            return sp;
        }

        @Override
        public long serializedSize(SchedulerParameter t, int version)
        {
            TypeSizes sizes = TypeSizes.NATIVE;
            
            int size = 0;
            
            size += sizes.sizeof(t.tardiness_tolerance);
            size += sizes.sizeof(t.staleness_tolerance);
            
            size += sizes.sizeof(t.tardiness_deadline);
            size += sizes.sizeof(t.staleness_deadline);
            
            size += sizes.sizeof(t.QoS_preference);
            size += sizes.sizeof(t.query_weight);
            
            //system behaviour
            size += sizes.sizeof(t.isInstalled);
            
            //important timestamp
            size += sizes.sizeof(t.client_issue_time);
            size += sizes.sizeof(t.client_finished_time);
            size += sizes.sizeof(t.client_latency);
            
            size += sizes.sizeof(t.local_arrival_time);
            size += sizes.sizeof(t.local_start_time);
            size += sizes.sizeof(t.local_finished_time);
            
            //execution time estimation
            size += sizes.sizeof(t.estimated_QC_k);
            size += sizes.sizeof(t.estimated_UC_k);
            
            //the actual execution time
            size += sizes.sizeof(t.actual_QC_k);
            size += sizes.sizeof(t.actual_UC_k);
            
            
            size += sizes.sizeof(t.first_unapplied_time);
            
            
            return size;
        }
        
    }
}
