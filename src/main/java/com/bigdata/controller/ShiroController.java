package com.bigdata.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigdata.entity.UserInfo;

@Controller
@RequestMapping("/shiroBus")
public class ShiroController {
	
	private final Logger logger = LoggerFactory.getLogger(ShiroController.class);
	
	@RequestMapping(value="/hello")
	public String helloWorld(){
		System.out.println("hello world!!!");
		return "appmap";
	}
	
	@ResponseBody
	@RequestMapping(value="/login")
	public Map<String, String> login(String username, String password){
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Map<String, String> map = new HashMap<String, String>();
		try{
			user.login(token);
			UserInfo userInfo = (UserInfo) user.getPrincipal();
			map.put("username", userInfo.getUserName());
			map.put("errorMsg", "ok");
		} catch (UnknownAccountException uae) {
			logger.error("UnknownAccountException ==>>", uae);
			map.put("errorMsg", "账号不存在!");
		} catch (IncorrectCredentialsException ice) {
			logger.error("IncorrectCredentialsException ==>>", ice);
			map.put("errorMsg", "密码错误!");
		} catch (LockedAccountException lae) {
			logger.error("LockedAccountException ==>>", lae);
			map.put("errorMsg", "账号被锁定!");
		} catch (Exception e) {
			logger.error("Exception ==>>", e);
			map.put("errorMsg", "未知错误,请联系管理员");
		}
		
		return map;
	}
	
}
