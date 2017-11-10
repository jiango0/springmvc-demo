package com.test;

import com.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestMain11 {

    public static void main(String[] args){
//        System.out.println(JedisUtils.hincrby("hincrby_1", "h_2", 1));
//        System.out.println(JedisUtils.expire("hincrby_1", 100000));

//        System.out.println(JedisUtils.exists("hincrby_1"));
//        System.out.println(JedisUtils.mapExists("hincrby_2", "h_2"));

        Jedis jedis = JedisUtils.getJedis();
        Transaction transaction = jedis.multi();
        transaction.incr("multi_t");
        transaction.expire("multi_t", 10000);
        transaction.exec();

        JedisUtils.getPool().returnResource(jedis);
    }

}
