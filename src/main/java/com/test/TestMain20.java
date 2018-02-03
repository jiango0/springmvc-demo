package com.test;

import com.sun.xml.internal.ws.api.server.SDDocumentFilter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestMain20 {

    public static void main(String[] args) throws ParseException {

        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_YEAR));

        String lastDate = "2018-1-1";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.parse(lastDate);

//        System.out.println(c.getTimeInMillis());
        System.out.println((c.getTimeInMillis() - format.parse(lastDate).getTime()) / (1000*3600*24) );

        System.out.println(getDateList(format.parse(lastDate), new Date()).toString());
    }

    public static List<String> getDateList(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(endDate);
        List<String> result = new ArrayList<>();
        long day = ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24))+1;
        for(int i=0; i<day; i++) {
            result.add(sdf.format(c.getTime()));
            c.add(Calendar.DATE, -1);
        }

        return result;
    }


}
