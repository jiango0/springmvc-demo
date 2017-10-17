package com.bigdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigdata.service.DubboService;


@Controller
@RequestMapping("/dubbo")
public class DubboController {
	
	@Autowired
	private DubboService dubboService;
	
	@ResponseBody
	@RequestMapping(value="/hello")
	public String helloWorld() {
		return dubboService.getProduct();
	}
	
}
