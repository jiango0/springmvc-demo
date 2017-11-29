package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain14 {

    public static void main(String[] args) {
        System.out.println(matcher("123f", "[0-9]{1,30}"));
    }

    public static boolean matcher(Object obj, String regEx) {
        if(obj == null || regEx == null){
            return false;
        }
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(obj.toString());
        return matcher.matches();
    }

}
