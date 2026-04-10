package com.tg.nutricode.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tg.nutricode.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // gera o Access Token (2 horas)
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("nutricode")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateAccessTokenExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token");
        }
    }

    // gera o Refresh Token (30 dias)
    public String generateRefreshToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("nutricode")
                    .withSubject(user.getEmail())
                    .withClaim("type", "refresh") // identifica que é refresh
                    .withExpiresAt(generateRefreshTokenExpiration())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating refresh token");
        }
    }

    // valida qualquer token e retorna o email
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("nutricode")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    // Access Token expira em 2 horas
    private Instant generateAccessTokenExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    // Refresh Token expira em 30 dias
    private Instant generateRefreshTokenExpiration() {
        return LocalDateTime.now().plusDays(30).toInstant(ZoneOffset.of("-03:00"));
    }
}