package com.test;

public class TestMainA {

    public static void main(String[] args){
    }

    public static void get(String... params){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            if (i > 0)
                sb.append(",");
            sb.append(params[i]);
        }
        System.out.println(sb.toString());
    }

    public static void get(String code, String msg, String... params){

    }

}
