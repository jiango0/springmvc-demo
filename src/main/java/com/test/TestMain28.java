package com.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMain28 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
//
//        c.setTime(new Date());
//        c.add(Calendar.DATE, -1);
//
//        System.out.println(sdf.format(c.getTime()));
        Integer boughtDays = 10;
        Date now = new Date();
        Date start_time = DateUtils.round(DateUtils.addDays(now,-1), Calendar.DATE);
        Date end_time = DateUtils.addMilliseconds(DateUtils.round(DateUtils.addDays(start_time,boughtDays+1),Calendar.HOUR_OF_DAY),-1);
        System.out.println(sdf.format(DateUtils.addDays(now,-1)));
        System.out.println(sdf.format(start_time));
        System.out.println(sdf.format(end_time));

    }

}
