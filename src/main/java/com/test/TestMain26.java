package com.test;

public class TestMain26 {

    public static void main(String[] args) {

    }

    public synchronized void test() {
        System.out.println("test test test");
    }

    public void test2() {
        synchronized (this) {}
    }

    public synchronized void test3() {
        System.out.println("test3 test3 test3");
    }

}
