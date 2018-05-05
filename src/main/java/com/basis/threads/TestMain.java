package com.basis.threads;

public class TestMain {

    public static void main(String[] args) {
//        TestMain.sleepT();
//        TestMain.waitT();
//        TestMain.syncT();
        TestMain.threadRun();
    }

    public static void sleepT() {
        SleepService sleep = new SleepService();
        Thread thread1 = new Thread(() -> {
            sleep.mSleep();
        });
        Thread thread2 = new Thread(() -> {
            sleep.mWait();
        });
        thread1.start();
        thread2.start();
    }

    public static void waitT() {
        WaitService waitService = new WaitService();
        Thread thread1 = new Thread(() -> {
            waitService.out("a");
        });
        Thread thread2 = new Thread(() -> {
            waitService.out("b");
        });
        thread1.start();
        thread2.start();
    }

    public static void syncT() {
        ThreadSyncService sync = new ThreadSyncService();

        Thread thread1 = new Thread(() -> {
            sync.run();
        });

        Thread thread2 = new Thread(() -> {
            sync.run2();
        });

        thread1.start();
        thread2.start();
    }

    public static void threadRun() {
        int i = 0;
        for (; i<100; i++) {
            int finalI = i;
            ThreadPoolUtils.addTask(() -> {
                System.out.println(finalI);
            });
        }
    }

}
