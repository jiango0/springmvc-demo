package com.basis.collection;

import org.apache.lucene.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInfo {

    public static void main(String[] args) {
        arrSorted();
        arrRepeat();
    }

    /**
     * 数组排序
     * */
    public static void arrSorted() {
        int[] arr = {1, 5, 2, 6, 3, 9};
        int a;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    a = arr[i];
                    arr[i] = arr[j];
                    arr[j] = a;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 数组去重
     * */
    public static void arrRepeat() {
        int[] arr = {1, 4, 4, 3, 2, 5, 5, 6, 6};
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    j = ++i;
                }
            }
            list.add(arr[i]);
        }

        System.out.println(list.toString());
    }

}
