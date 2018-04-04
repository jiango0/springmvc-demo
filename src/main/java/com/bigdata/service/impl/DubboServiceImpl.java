package com.bigdata.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bigdata.service.DubboService;

@Service
public class DubboServiceImpl implements DubboService {


	
	public String getProduct() {
		return "";
	}
	
}
