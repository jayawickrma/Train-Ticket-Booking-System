package com.example.trainticketbookingsystem.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
    String refreshToken(UserDetails userDetails);
}
