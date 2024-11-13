package com.diet.auth.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private static final String SECRET = "ADFLAKSDLFADSJASDFKLJASDFJALSJDKFKSDLFJASDKFJJKAHSDFKHASDKFHLSHDFKJHASDKJF";

	public void validateToken(String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}

	public String createToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(claims, username);
	}

	private String generateToken(Map<String, Object> claims, String username) {
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000)).signWith(getSignKey(),SignatureAlgorithm.HS256)
				.compact();
	}

	public Key getSignKey() {
		byte[] hashKey = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(hashKey);

	}
	
	public String getUserId(String token) {
		Claims claims=(Claims) Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

}
