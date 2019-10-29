package com.oyms.util;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.stereotype.Service;

import com.oyms.exception.ApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class GetAndCheckToken {
	final static String base64EncodedSecretKey = "lrp19970511";
	final static long TOKEN_EXP = 5*60*1000;
	
	public static String getToken(String userName) {
		 
		return Jwts.builder()
				.setSubject(userName)
				.claim("roles", "user")
				.setIssuedAt(new Date())
			 	.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
				.signWith(SignatureAlgorithm.HS256, base64EncodedSecretKey)
				.compact();
}
	
	/**
	* 检查token,只要不正确就会抛出异常
	 * @throws UserLoginException 
	 * @throws UserLoginInvalidException 
	**/
	 
	public static Claims checkToken(String token) throws ServletException {
		try {
			final Claims claims = Jwts.parser().setSigningKey(base64EncodedSecretKey).parseClaimsJws(token).getBody();
			return claims;
		} catch (ExpiredJwtException e1) {
			throw new ApiException("登录信息过期，请重新登录",602);
		} catch (Exception e) {
			throw new ApiException("用户未登录，请重新登录",601);
		}
		}
}
