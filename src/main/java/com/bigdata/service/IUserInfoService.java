package com.bigdata.service;

import com.bigdata.entity.UserInfo;

public interface IUserInfoService {
	
	UserInfo selectByUserInfo(UserInfo userInfo);
	
}
