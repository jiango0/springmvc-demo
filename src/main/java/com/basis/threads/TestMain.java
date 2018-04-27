package com.basis.threads;

public class TestMain {

    public static void main(String[] args) {
//        TestMain.sleepT();
        TestMain.waitT();
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

}
