package com.test;

import com.alibaba.fastjson.JSON;
import com.entity.TestEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TestMain34 {

    public static void main(String[] args) {

        TestEntity testEntity = new TestEntity();

        testEntity.setName("jzc");
        testEntity.setPrice(new BigDecimal("0.01"));
        testEntity.setProduct_price(new BigDecimal("0.02"));

        Map<String, Object> map = new HashMap<>();
        map.put("data", testEntity);
        map.put("opType", "ADD");

        System.out.println(JSON.toJSONString(map));

    }

}
