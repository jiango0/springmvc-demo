package com.test;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain5 {
	
	public static void main(String[] args){
		Date c1 = new GregorianCalendar(2017, 8, 13, 0, 0, 0).getTime();
		Date c2 = new GregorianCalendar(2017, 8, 11, 0, 0, 0).getTime();
		
		
		System.out.println(c1.getTime());
		System.out.println( (c2.getTime()-c1.getTime())/(24 * 60 * 60 * 1000) );
	}
	
}
