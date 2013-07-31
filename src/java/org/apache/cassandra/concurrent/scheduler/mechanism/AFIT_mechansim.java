package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.scheduler.TPE.Chen_JMXConfigurableThreadPoolExecutor;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;

public class AFIT_mechansim extends Chen_JMXConfigurableThreadPoolExecutor
{

    public AFIT_mechansim(int corePoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, NamedThreadFactory threadFactory,
            String jmxPath, BlockingQueue<Runnable> writeQueue, Policy priority_calculate)
    {
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath, writeQueue, priority_calculate);
        // TODO Auto-generated constructor stub
    }

}
