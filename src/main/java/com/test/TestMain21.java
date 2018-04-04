package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestMain21 {

    public static void main(String[] args) {
        String lastDate = "2017-07-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        try {
            start = format.parse(lastDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getMonth(2017);
        getWeek(2018);
        getYear(start);
    }

    public static void getMonth(int year) {
        Calendar c = Calendar.getInstance();
        int count = 12;
        if(c.get(Calendar.YEAR) == year) {
            count = c.get(Calendar.MONTH)  ;
        }
        List<Map<String, String>> result = new ArrayList<>();
        for(int i=0; i<count; i++) {
            Map<String, String> map = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            Integer month = (count - i);

            stringBuilder.append(String.valueOf(month).length() == 1 ? "0"+month : month);
            map.put("id", stringBuilder.toString());
            map.put("text", year+"年"+month+"月");
            result.add(map);
        }

        System.out.println(result.toString());
    }

    public static void getWeek(int year) {
        Calendar c = Calendar.getInstance();
        int count = 0;
        if(c.get(Calendar.YEAR) == year) {
            count = getWeekNumOfYear(c.getTime()) - 1;
        } else {
            count = getMaxWeekNumOfYear(year);
        }
        List<Map<String, String>> result = new ArrayList<>();
        for(int i=0; i<count; i++) {
            Map<String, String> map = new HashMap<>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            Integer month = (count - i);

            stringBuilder.append(String.valueOf(month).length() == 1 ? "0"+month : month);
            map.put("id", stringBuilder.toString());
            map.put("text", year+"年"+"第"+month+"周");
            result.add(map);
        }

        System.out.println(result.toString());
    }

    public static void getYear(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        Calendar c2 = Calendar.getInstance();
        int years = c2.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        List<Map<String, String>> result = new ArrayList<>();
        for(int i=-1; i<years; i++) {
            String year = format.format(c2.getTime());
            Map<String, String> map = new HashMap<>();
            map.put("id", year+"");
            map.put("text", year+"年");
            c2.add(Calendar.YEAR, -1);
            result.add(map);
        }

        System.out.println(result.toString());
    }




    /**
     * 取得某天是一年中的多少周
     * @param date
     * @return
     */
    public static int getWeekNumOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取哪一年共有多少周
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekNumOfYear(c.getTime());
    }


}
