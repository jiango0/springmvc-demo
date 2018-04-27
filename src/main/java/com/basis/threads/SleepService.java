package com.basis.threads;

public class SleepService {

    public void mSleep() {
        synchronized (this) {
            try {
                System.out.println(" Sleep。 当前时间：" + System.currentTimeMillis());
                Thread.sleep(3*1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            System.out.println(" Sleep 结束时间：" + System.currentTimeMillis());
        }
    }

}
