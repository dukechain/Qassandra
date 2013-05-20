package org.apache.cassandra.concurrent.scheduler.mechanism;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


import org.apache.cassandra.concurrent.scheduler.TPE.Chen_ThreadPoolExecutor;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;

public class HOD_mechanism extends Chen_ThreadPoolExecutor
{

    public HOD_mechanism(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            ThreadFactory threadFactory, RejectedExecutionHandler handler, BlockingQueue<Runnable> writeQueue, Policy priority_calculate)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler, writeQueue, priority_calculate);
        // TODO Auto-generated constructor stub
    }

    

}
