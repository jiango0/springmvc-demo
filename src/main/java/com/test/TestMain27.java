package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestMain27 {

    public static void main(String[] args) {
        try {

            System.out.println(URLEncoder.encode("{obj=123213}", "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
