package com.oyms.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oyms.mapper.UserMapper;
import com.oyms.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public void userRegister(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public boolean checkUserName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.selectByName(userName);
	}

	public boolean checkForLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(userName, userName);
		params.put(userPassword, userPassword);
		return userMapper.selectForLogin(userName, userPassword);
	}

	// 获取登录用户的url
	public String getUserImg(String userName) {
		return userMapper.getUserImg(userName);
	}
	
}
