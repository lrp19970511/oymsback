package com.oyms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.oyms.exception.ApiException;

import io.jsonwebtoken.Claims;

public class JWTInterceptor extends HandlerInterceptorAdapter{
	    @Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
			String token = request.getHeader("token");
			System.err.println(token);
			if (token == null || token =="" || token.startsWith("[")) {
			response.setStatus(600);
			throw new ApiException("用户未登录",600);
			}
			//验证token
			Claims claims = GetAndCheckToken.checkToken(token);
			request.setAttribute("username",claims.getSubject());
				return true;
			}
}

