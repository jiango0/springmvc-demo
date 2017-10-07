package com.bigdata.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface CommonProcessor {
	
	void execute(HttpServletRequest request, List list);
	
}
