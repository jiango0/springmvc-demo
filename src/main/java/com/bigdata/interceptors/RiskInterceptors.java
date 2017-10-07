package com.bigdata.interceptors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SuppressWarnings("unchecked")
public class RiskInterceptors extends HandlerInterceptorAdapter implements ApplicationContextAware {
	
	// Spring应用上下文环境  
    private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		RiskInterceptors.applicationContext = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {  
        return applicationContext;  
    }
    
	//这是后台配置的一个规则
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	
	{
		//这是初始化的次数风控
		list.add(new HashMap<String, Object>(){{
			put("clazz", "com.bigdata.interceptors.RangeProcessor");
			put("rule", new ArrayList(){{
				add(new HashMap<String, String>(){{
					put("field", "userId_uri");
					put("count", "100");
					put("time", "10");
				}});
				add(new HashMap<String, String>(){{
					put("field", "ip_uri");
					put("count", "100");
					put("time", "10");
				}});
			}});
		}});
		
		//这是初始化的一个范围风控
		list.add(new HashMap<String, Object>(){{
			put("clazz", "com.bigdata.interceptors.FrequencyProcessor");
			put("rule", new ArrayList(){{
				add(new HashMap<String, String>(){{
					put("field", "amount");
					put("max", "1000");
					put("min", "1");
				}});
			}});
		}});
		
	}
	//这是拦截器中触发的方法，此处会循环处理规则
	public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {
		
		for(Map<String, Object> map:list){
			String clazz = (String)map.get("clazz");
			CommonProcessor processor = (CommonProcessor)RiskInterceptors.getApplicationContext().getBean(clazz);
			processor.execute(request, (List)map.get("rule"));
		}
		
		return true;
	}

	
}
