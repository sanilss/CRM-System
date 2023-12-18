package com.algo.service;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	public static final String SECRET ="D10624DB2B1492B7B7392470369766872CCD06EDFB42DB512C86783E53FC47AF8239F971FB77DFAC9A416347C0CE76ED8A8BF1730FFAE925ADD27E5CFF9F9BC0C4663ED253DDFFAB1D930E9395D0373E41B7FF9B6D9D010B587AF3B05DDAA7C706C228465987F7758B0BDB22103FEAF801228D7BA61E8C19B391863EA35519E7";
	
	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts
	                .parserBuilder()
	                .setSigningKey(getSignKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
	
	
	
	
	
	public String generateToken(String userName) {
		Map<String,Object> claims=new HashMap<>();
		
		return createToken(claims,userName);
	}
	
	private String createToken(Map<String, Object> claims,String userName) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(userName)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
				.signWith(getSignKey(),SignatureAlgorithm.HS256) .compact();
	}

	private Key getSignKey() {
		// TODO Auto-generated method stub
		byte[] keyBytes=Decoders.BASE64.decode(SECRET);
				return Keys.hmacShaKeyFor(keyBytes);
	}
}
