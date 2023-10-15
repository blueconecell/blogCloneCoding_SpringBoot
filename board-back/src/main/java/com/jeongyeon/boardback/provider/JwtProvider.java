package com.jeongyeon.boardback.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtProvider {

    @Value("${secret-key}")
    private String secretKey;
    
    public String create(String email){
        // java.util 의 자동완성으로 Date를 불러와 1시간 만료기간을 만들어준다.
        Date expireDate = Date.from(Instant.now().plus(1,ChronoUnit.HOURS));
        //jwt생성
        String jwt = Jwts.builder()
            .signWith(SignatureAlgorithm.ES256,secretKey)
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expireDate)
            .compact();

        return jwt;
    }
    public String validate(String jwt){
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return claims.getSubject();
    }
}
