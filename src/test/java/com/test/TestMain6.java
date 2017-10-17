package com.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain6 {
	
	public static void main(String[] args){
		String monthDay = new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		System.out.println(monthDay.substring(0, 6));
		System.out.println(monthDay.substring(6));
		
		BigDecimal amount = new BigDecimal(0);
		getAmount(amount);
		System.out.println(amount);
	}
	
	public static void getAmount(BigDecimal amount){
		amount = amount.add(new BigDecimal(10));
	}
	
}
