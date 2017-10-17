package com.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestMain7 {
	
	public static void main(String[] args){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
		
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
	}
	
}
