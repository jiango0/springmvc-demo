package com.bigdata.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bigdata.service.DubboService;
import com.domain.service.ProductService;

@Service
public class DubboServiceImpl implements DubboService {
	
	@Reference
	ProductService productService;

	
	public String getProduct() {
		return productService.getName();
	}
	
}
