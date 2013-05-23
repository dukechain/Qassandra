package org.apache.cassandra.concurrent.scheduler.TPE;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


import org.apache.cassandra.concurrent.JMXConfigurableThreadPoolExecutorMBean;
import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;


public class Chen_JMXConfigurableThreadPoolExecutor extends Chen_JMXEnabledThreadPoolExecutor
{
    /*public Chen_JMXConfigurableThreadPoolExecutor(int corePoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath)
    {
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath);
    }*/
    
    
    public Chen_JMXConfigurableThreadPoolExecutor(int corePoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath,
            BlockingQueue<Runnable> writeQueue,
            Policy priority_calculate)
    {
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath,
                writeQueue, priority_calculate);
    }
}
