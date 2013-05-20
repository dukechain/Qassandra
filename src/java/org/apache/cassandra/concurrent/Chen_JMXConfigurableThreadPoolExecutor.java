package org.apache.cassandra.concurrent;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.cassandra.net.MessageDeliveryTask;
import org.junit.internal.runners.statements.RunAfters;

public class Chen_JMXConfigurableThreadPoolExecutor extends JMXEnabledThreadPoolExecutor implements JMXConfigurableThreadPoolExecutorMBean
{
    public Chen_JMXConfigurableThreadPoolExecutor(int corePoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            NamedThreadFactory threadFactory,
            String jmxPath)
    {
        super(corePoolSize, keepAliveTime, unit, workQueue, threadFactory, jmxPath);
    }
    
/*    private boolean isPaused;
    private ReentrantLock pauseLock = new ReentrantLock();
    private Condition unpaused = pauseLock.newCondition();

    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        pauseLock.lock();
        
        try {
          while (isPaused) unpaused.await();
        } catch(InterruptedException ie) {
          t.interrupt();
        } finally {
          pauseLock.unlock();
        }
    }*/
    
    /*protected void afterExecute(Runnable r, Throwable t)
    {
        super.afterExecute(r, t);
        
        BlockingQueue <Runnable> queue = getQueue();
        
        Iterator iter =  queue.iterator();
        
        while (iter.hasNext())
        {
            MessageDeliveryTask task = (MessageDeliveryTask) iter.next();
            
        }
        
        
    }*/
}
