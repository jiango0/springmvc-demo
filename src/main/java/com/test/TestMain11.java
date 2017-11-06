package com.test;

import com.utils.JedisUtils;

public class TestMain11 {

    public static void main(String[] args){
        System.out.println(JedisUtils.hincrby("hincrby_1", "h_2", 1));
//        System.out.println(JedisUtils.expire("hincrby_1", 100000));

//        System.out.println(JedisUtils.exists("hincrby_1"));
//        System.out.println(JedisUtils.mapExists("hincrby_2", "h_2"));

    }

}
