package com.test;

import com.mongo.common.MongodbComponent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestMain32 {

    public static void main(String[] args) {
        MongodbComponent<String> mongodbComponent = new MongodbComponent<String>();

        Type type = ((ParameterizedType) mongodbComponent.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(type);

    }

}
