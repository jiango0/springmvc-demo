package com.test;

import java.util.Arrays;

public class TestMain16 {

    private static Integer[] l = new Integer[1024];

    public static void main(String[] args) {
        int max = 1024;
        int current = 0;
        int j = 512;
        while (true) {
            if(current == max) {
                return;
            }
            if(current == 0){
                l[0] = 0;
                System.out.println(l[current]);
            } else if (current == 1) {
                l[512] = 512;
                System.out.println(l[512]);
            } else {
                int k = right();
                l[k] = k;
                System.out.println(l[k]);
            }

            current++;
        }
    }

    private static int right() {
        for(int i=1;i<l.length;i++){
            if(l[i] != null){
                int j = i + 512;
                j = j == 1024 ? 0 : j;
                if(l[j] != null){
                    return i / 2;
                } else {
                    return i + 512;
                }
            }
        }

        return 0;
    }

}
