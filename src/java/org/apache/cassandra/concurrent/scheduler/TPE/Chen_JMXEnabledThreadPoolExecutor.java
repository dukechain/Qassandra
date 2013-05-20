package org.apache.cassandra.concurrent.scheduler.TPE;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.cassandra.concurrent.NamedThreadFactory;
import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.scheduler.policy.Policy;
import org.apache.cassandra.metrics.ThreadPoolMetrics;
import org.apache.pig.parser.QueryParser.null_check_cond_return;

/**
 * This is a wrapper class for the <i>ScheduledThreadPoolExecutor</i>. It provides an implementation
 * for the <i>afterExecute()</i> found in the <i>ThreadPoolExecutor</i> class to log any unexpected
 * Runtime Exceptions.
 */

public class Chen_JMXEnabledThreadPoolExecutor extends Chen_DebuggableThreadPoolExecutor
{
    private final String mbeanName;
    private final ThreadPoolMetrics metrics;

    public Chen_JMXEnabledThreadPoolExecutor(String threadPoolName)
    {
        this(1, Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), 
                new NamedThreadFactory(threadPoolName), "internal");
    }

    public Chen_JMXEnabledThreadPoolExecutor(String threadPoolName, String jmxPath)
    {
        this(1, Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
                new NamedThreadFactory(threadPoolName), jmxPath);
    }

    public Chen_JMXEnabledThreadPoolExecutor(String threadPoolName, int priority)
    {
        this(1, Integer.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
                new NamedThreadFactory(threadPoolName, priority), "internal");
    }

    public Chen_JMXEnabledThreadPoolExecutor(int corePoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath)
    {
        this(corePoolSize, corePoolSize, keepAliveTime, unit, 
                workQueue, threadFactory, jmxPath, null, null);
    }

    public Chen_JMXEnabledThreadPoolExecutor(int corePoolSize,
                                        int maxPoolSize,
                                        long keepAliveTime,
                                        TimeUnit unit,
                                        BlockingQueue<Runnable> workQueue,
                                        NamedThreadFactory threadFactory,
                                        String jmxPath,
                                        BlockingQueue<Runnable> writeQueue,
                                        Policy priority_calculate)
    {
        super(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue, 
                threadFactory, writeQueue, priority_calculate);
        super.prestartAllCoreThreads();

        metrics = new ThreadPoolMetrics(this, jmxPath, threadFactory.id);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        mbeanName = "org.apache.cassandra." + jmxPath + ":type=" + threadFactory.id;

        try
        {
            mbs.registerMBean(this, new ObjectName(mbeanName));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public Chen_JMXEnabledThreadPoolExecutor(Stage stage)
    {
        this(stage.getJmxName(), stage.getJmxType());
    }

    private void unregisterMBean()
    {
        try
        {
            ManagementFactory.getPlatformMBeanServer().unregisterMBean(new ObjectName(mbeanName));
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        // release metrics
        metrics.release();
    }

    @Override
    public synchronized void shutdown()
    {
        // synchronized, because there is no way to access super.mainLock, which would be
        // the preferred way to make this threadsafe
        if (!isShutdown())
        {
            unregisterMBean();
        }
        super.shutdown();
    }

    @Override
    public synchronized List<Runnable> shutdownNow()
    {
        // synchronized, because there is no way to access super.mainLock, which would be
        // the preferred way to make this threadsafe
        if (!isShutdown())
        {
            unregisterMBean();
        }
        return super.shutdownNow();
    }

    /**
     * Get the number of completed tasks
     */
    public long getCompletedTasks()
    {
        return getCompletedTaskCount();
    }

    /**
     * Get the number of tasks waiting to be executed
     */
    public long getPendingTasks()
    {
        return getTaskCount() - getCompletedTaskCount();
    }

    public int getTotalBlockedTasks()
    {
        return (int) metrics.totalBlocked.count();
    }

    public int getCurrentlyBlockedTasks()
    {
        return (int) metrics.currentBlocked.count();
    }

    public int getCoreThreads()
    {
        return getCorePoolSize();
    }

    public void setCoreThreads(int number)
    {
        setCorePoolSize(number);
    }

    public int getMaximumThreads()
    {
        return getMaximumPoolSize();
    }

    public void setMaximumThreads(int number)
    {
        setMaximumPoolSize(number);
    }

    @Override
    protected void onInitialRejection(Runnable task)
    {
        metrics.totalBlocked.inc();
        metrics.currentBlocked.inc();
    }

    @Override
    protected void onFinalAccept(Runnable task)
    {
        metrics.currentBlocked.dec();
    }

    @Override
    protected void onFinalRejection(Runnable task)
    {
        metrics.currentBlocked.dec();
    }
}

