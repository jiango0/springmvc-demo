package com.basis.threads;

/**
 * 关于
 * synchronized method
 * synchronized 块
 * 在同一个对象里面，如果run 与 run2 都是锁的对象，
 * */
public class ThreadSyncService {

    public synchronized void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("running test 1");
    }

    public synchronized void run2() {
        System.out.println("running test 2");
    }

}
