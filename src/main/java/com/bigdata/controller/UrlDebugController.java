package com.bigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/urldebug")
public class UrlDebugController {
	
	@RequestMapping(value="/hello")
	public String helloWorld(){
		
		return "urldebug";
	}
	
}
