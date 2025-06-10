package com.example.project.security;

import java.security.Key;
import java.util.Date;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.example.project.config.JwtConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtSecurity {
    
    private final JwtConfig jwtConfig;
    private final Key key;

    public JwtSecurity (JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(jwtConfig.getSecretKey().getBytes()));
    }

    // tạo chuỗi jwt
    public String generateToken (Long studentId, String email) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtConfig.getExpirationTime());

        return Jwts.builder().setSubject(String.valueOf(studentId)).claim("email", email).setIssuedAt(now).setExpiration(expiration).signWith(key, SignatureAlgorithm.HS512).compact();
    }
    
}
