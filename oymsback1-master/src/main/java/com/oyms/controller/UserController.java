package com.oyms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.oyms.dto.ApiDTO;
import com.oyms.model.User;
import com.oyms.service.UserService;
import com.oyms.util.GetAndCheckToken;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	@Autowired
	private ApiDTO<?> apiDTO;
	
	@PostMapping("/register")
	public ApiDTO<?> userRegister(@RequestBody JSONObject jsonObject) {
		String userName = jsonObject.getString("userName");
		String userPassword = jsonObject.getString("userPassword");
		String userImageUrl = jsonObject.getString("userImageUrl");
		Date nowDate = new Date();
		user.setCreatetime(nowDate);
		user.setUserimg(userImageUrl);
		user.setUsername(userName);
		user.setUserpassword(userPassword);
		if (userService.checkUserName(userName)) {
			apiDTO.setIsSuccess(false);
			apiDTO.setCode(500);
			apiDTO.setMessage("用户已存在");
			return apiDTO;
		} else {
			userService.userRegister(user);
			apiDTO.setIsSuccess(true);
			apiDTO.setCode(200);
			apiDTO.setMessage("注册成功");
			return apiDTO;
		}
	}

	@PostMapping("/login")
	public ApiDTO<?> userLogin(@RequestBody JSONObject jsonObject) {
		String userName = jsonObject.getString("userName");
		String userPassword = jsonObject.getString("userPassword");
		user.setUsername(userName);
		user.setUserpassword(userPassword);
		if (userService.checkForLogin(userName, userPassword)) {
			String token = GetAndCheckToken.getToken(userName);
			apiDTO.setIsSuccess(true);
			apiDTO.setCode(200);
			apiDTO.setToken(token);
			apiDTO.setMessage(userService.getUserImg(userName));
		} else {
			apiDTO.setIsSuccess(false);
			apiDTO.setCode(500);
			apiDTO.setMessage("用户名或密码错误");
		}
		return apiDTO;
	}
	
}
