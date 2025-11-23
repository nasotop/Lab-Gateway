package com.lab.gateway.lab_gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    // Debe tener al menos 256 bits para HS256 (~32 bytes)
    private final SecretKey secretKey;

    public JwtService(@Value("${jwt.secret}") String secret) {
        byte[] decoded = java.util.Base64.getDecoder().decode(secret);
        this.secretKey = io.jsonwebtoken.security.Keys.hmacShaKeyFor(decoded);
    }

    public String generateToken(String username, Long userId, String role) {
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(username)
                .claim("id", userId)
                .claim("role", role)
                .setIssuedAt(new java.util.Date())
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 3600000))
                .signWith(secretKey, io.jsonwebtoken.SignatureAlgorithm.HS256)
                .compact();
    }
 private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    public Long extractUserId(String token) {
        return parseClaims(token).get("id", Long.class);
    }

    public String extractRole(String token) {
        return parseClaims(token).get("role", String.class);
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = parseClaims(token);

            if (claims.getSubject() == null) return false;
            if (claims.get("id", Long.class) == null) return false;
            if (claims.get("role", String.class) == null) return false;

            return true;

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
