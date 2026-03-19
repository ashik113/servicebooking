package com.ashik.servicebooking.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY =
            "eaCZstTAFr19SfXpzvZTgCeKg2ZPar0blM1NiJewvXtbVhCT81v7nrU58GRcmt1aEMUxHCIbdjMV6gUngwiPk2";


    public static String generateToken(String username) {
        System.out.println("SECRET: " + SECRET_KEY);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static String validateToken(String token) {
        System.out.println("SECRET: " + SECRET_KEY);

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token).
                getBody().
                getSubject();
    }



}
