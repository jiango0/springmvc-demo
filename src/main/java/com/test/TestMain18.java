package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain18 {

    public static void main(String[] args) {
        String str = "  1 2 3 \r\n 4   ";
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");

            System.out.println(dest.trim());
        }
    }

}
