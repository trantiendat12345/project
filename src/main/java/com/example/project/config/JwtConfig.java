package com.example.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}") //gọi giá trị secret key
    private String secretKey;

    @Value("${jwt.expiration}") // thời gian hết hạn của token
    private Long expirationTime;

    // @Value("${jwt.issuer}")
    // private String issuer;

    // @Value("${jwt.expirationRefreshToken}")
    // private Long refreshTokenExpirationTime;

    public String getSecretKey() {
        return secretKey;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    // public String getIssue() {
    //     return issuer;
    // }

    // public Long getRefreshTokenExpirationTime() {
    //     return refreshTokenExpirationTime;
    // }
    
}
