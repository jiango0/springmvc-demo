package com.bigdata.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigdata.entity.UserInfo;
import com.bigdata.service.IUserInfoService;

@Component("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken tk = (UsernamePasswordToken) token;
		UserInfo ui = new UserInfo();
		ui.setUserNo(tk.getUsername());
		ui = userInfoService.selectByUserInfo(ui);
		
//		if(tk.getUsername().equals("jiang")){
//			ui = new UserInfo();
//			
//			ui.setUserId(1);
//			ui.setUserName("姜志超");
//			ui.setPassword("111111");
//		}
		
		if(ui != null){
			return new SimpleAuthenticationInfo(ui, ui.getPassword().toCharArray(), getName());
		}else{
			return null;
		}
		
	}

}
