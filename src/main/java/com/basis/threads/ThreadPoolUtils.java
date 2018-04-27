package com.basis.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    protected static ExecutorService pool = new ThreadPoolExecutor(
            getPoolCoreSize(),//核心线程数
            getPoolMaxSize(),//线程池所能容纳的最大线程数
            getPoolWaitTime(),//非核心线程的闲置超时时间，超过这个时间就会被回收
            TimeUnit.MICROSECONDS,//指定keepAliveTime的单位
            new LinkedBlockingQueue<>(getQueueSize()),//线程池中的任务队列
            new ThreadPoolExecutor.CallerRunsPolicy()//线程工厂，提供创建新线程的功能
    );

    private static int getQueueSize() {
        return 10;
    }

    private static int getPoolCoreSize() {
        return 10;
    }

    private static int getPoolMaxSize() {
        return 10;
    }

    private static long getPoolWaitTime() {
        return 1000;
    }

    public static void addTask(Runnable task) {
        pool.execute(task);
    }

}
