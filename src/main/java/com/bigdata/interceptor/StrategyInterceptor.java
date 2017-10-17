package com.bigdata.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bigdata.scan.CommonProcess;

public class StrategyInterceptor extends HandlerInterceptorAdapter implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;
	
	private List<String> clazzList = new ArrayList<>();
	
	{
		clazzList.add("com.bigdata.scan.VisitsProcess");
		clazzList.add("com.bigdata.scan.ConditionProcess");
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		StrategyInterceptor.applicationContext = applicationContext;
	}
	
	public static Object getType(String clazz) {
		return applicationContext.getType(clazz);
	}
	
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(clazzList != null && !clazzList.isEmpty()){
			for(String clazz : clazzList){
				CommonProcess preocess = (CommonProcess) applicationContext.getBean(Class.forName(clazz).newInstance().getClass());
				preocess.execute(request);
			}
		}
		
		return true;
	}
	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}
	
}
