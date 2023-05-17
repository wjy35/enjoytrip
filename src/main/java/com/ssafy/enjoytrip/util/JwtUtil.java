package com.ssafy.enjoytrip.util;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Value("${jwt.salt}")
    private String SALT;

    @Value("${jwt.expmin}")
    private Long EXPIRE_MIN;

    public <T> String createAccessToken(String key, T data) {
        return create(key, data, "access-token",  this.EXPIRE_MIN);
    }

    public <T> String createRefreshToken(String key, T data) {
        return create(key,data,"refresh-token",this.EXPIRE_MIN);
    }

    private <T> String create(String key, T data,String subject, long expireMin){

        Claims claims = Jwts.claims()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*expireMin));

        claims.put(key,data);

        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SALT.getBytes())
                .compact();

        return jwt;
    }

    public boolean checkToken(final String token){
        try{
            Jwts.parser().setSigningKey(SALT.getBytes()).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
