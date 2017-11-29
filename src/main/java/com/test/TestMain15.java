package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain15 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(1511768960000L)));
    }

}
