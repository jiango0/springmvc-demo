package com.basis.threads;

public class WaitService {

    private Integer count = new Integer(1);

    public void out(String name) {
        synchronized (this) {
            try {
                for(int i=1; i<51; i++) {
                    this.notify();
                    System.out.println(name + count++);
                    this.wait();
                }
                this.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
