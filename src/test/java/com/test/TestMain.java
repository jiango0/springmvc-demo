package com.test;

import java.math.BigDecimal;

public class TestMain {
	
	private static double EARTH_RADIUS = 6378.137; 
	   
    private static double rad(double d) { 
        return d * Math.PI / 180.0; 
    }
	
	public static void main(String[] args){
		baseInit();
	}
	
	public static void baseInit(){
		Integer i = new Integer(1);
		Integer o = Integer.valueOf("1");
		
		System.out.println(new Integer(1).equals(new Integer(1)));
	}
	
	public static void distancs(){
		System.out.print(getDistance("30.5152080000", "114.2147110000", "30.5367350000", "114.1823720000"));
	}
	
	public static String getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str){
		//�û�����
		Double lat1 = Double.parseDouble(lat1Str);
		//�û�γ��
        Double lng1 = Double.parseDouble(lng1Str);
        //Ŀ�꾭��
        Double lat2 = Double.parseDouble(lat2Str);
        //Ŀ��γ��
        Double lng2 = Double.parseDouble(lng2Str);
         
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));
        distance = distance * EARTH_RADIUS;
        BigDecimal big = new BigDecimal(distance);
        String distanceStr = big.setScale(1, BigDecimal.ROUND_DOWN).toString() + "km";
        
        return distanceStr;
	}
	
}
