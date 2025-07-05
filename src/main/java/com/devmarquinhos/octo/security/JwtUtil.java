package com.devmarquinhos.octo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "macacocomebananaepapagaiocomenozes123456789";
    private final long EXPIRATION_DATE = 86400000;

    public String generateToken(String nomeUser){
        return Jwts.builder()
                .setSubject(nomeUser)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
