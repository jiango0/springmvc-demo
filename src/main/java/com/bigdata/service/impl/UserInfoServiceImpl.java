package com.bigdata.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata.dao.UserInfoMapper;
import com.bigdata.entity.UserInfo;
import com.bigdata.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfo selectByUserInfo(UserInfo userInfo) {
		return userInfoMapper.selectByUserInfo(userInfo);
	}
	
	
	
}
