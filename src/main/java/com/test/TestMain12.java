package com.test;

import com.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class TestMain12 {

    public static void main(String[] args){
        Jedis jedis = JedisUtils.getJedis();
        Set<String> set = jedis.keys("activity*");
        System.out.println(set.size());

        if(set != null && !set.isEmpty()){
            Iterator<String> it = set.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
                jedis.del(it.next());
            }
        }

//        System.out.println(jedis.exists("zgzyq_10015_15608"));

        JedisUtils.getPool().returnResource(jedis);
    }

}
