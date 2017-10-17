package com.bigdata.scan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class ConditionProcess implements CommonProcess {

	public void execute(HttpServletRequest request) {
		System.out.println("this is conditionProcess");
	}

}
