package com.example.MusouDB.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    // 1. Generar una clave secreta para firmar el JWT (HS256)
    private final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    // 2. Metodo para generar el JWT (cómo se firma, cuándo se emitió, subject,
    // expiración)
    public String generateToken(String nombreUsuario){
        long expiration = 1000 * 30 * 60; // 30 min = 1 800 000ms
        return Jwts.builder()
                .signWith(secretKey)
                .issuedAt(new Date())
                .subject(nombreUsuario)
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }

    // 3. Metodo para leer el JWT
    // Si el token es válido retorna un objecto Claims
    private Jws<Claims> parseToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token);
    }

    // 4. Metodo para comprobar si el token es válido
    // Si no, lanza una Exception
    // Permite encapsular el metodo parseToken();
    public boolean isValidToken(String token){
        try {
            parseToken(token);
            return true;
        } catch (JwtException ex){
            return false;
        }
    }

    // 5. Metodo para extraer el username a partir del token
    public String extractUsername(String token){
        return parseToken(token)
                .getPayload()
                .getSubject();
    }
}
