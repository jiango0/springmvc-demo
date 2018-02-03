package com.test;

import com.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Iterator;
import java.util.Set;

public class TestMain11 {

    public static void main(String[] args){
//        System.out.println(JedisUtils.hincrby("hincrby_1", "h_2", 1));
//        System.out.println(JedisUtils.expire("hincrby_1", 100000));

//        System.out.println(JedisUtils.exists("hincrby_1"));
//        System.out.println(JedisUtils.mapExists("hincrby_2", "h_2"));

        Jedis jedis = JedisUtils.getJedis();
//        Transaction transaction = jedis.multi();
//        System.out.println(transaction.get("multi_t").get());
//        Response<Long> incr = transaction.incr("multi_t");
//        System.out.println(incr.get());
//        transaction.expire("multi_t", 10000);
//        transaction.exec();
//        System.out.println(incr.get());

        Set<String> set = jedis.keys("activity*");
        if(set != null && !set.isEmpty()){
            String[] keys = new String[set.size()];
            Iterator<String> it = set.iterator();
            int i = 0;
            while(it.hasNext()){
                keys[i] = it.next();
                i++;
            }
            jedis.del(keys);
        }


        JedisUtils.getPool().returnResource(jedis);
    }

}
