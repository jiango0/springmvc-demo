package com.test;

import java.math.BigDecimal;

public class TestMain4 {
	
	public static void main(String[] args){
		BigDecimal decimal = new BigDecimal("20000");
		
		System.out.println(decimal.divideToIntegralValue(new BigDecimal("24")));
		
		System.out.println(decimal.remainder(new BigDecimal("24")));
		
		System.out.println(decimal.intValue() % 24);
	}
	
}
