package com.zuberi.cam.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String SECRET = "CHANGE_ME_SECRET"; // TODO move to config
    private static final long EXP_MS = 1000L * 60 * 60 * 24; // 24h

    public static String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXP_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
