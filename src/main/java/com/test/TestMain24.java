package com.test;

import org.springframework.http.HttpHeaders;

import java.util.Base64;

public class TestMain24 {

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        try {
            byte[] base64 = Base64.getEncoder().encode(new String("api_client:api_client_secret").getBytes());
            String header = new String(base64, "UTF8");
            System.out.println(header);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
