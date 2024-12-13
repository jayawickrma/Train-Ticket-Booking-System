package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.PasswordDto;
import com.example.trainticketbookingsystem.Security.Responce.JWTAuthResponse;
import com.example.trainticketbookingsystem.Security.Secure.SignIn;
import com.example.trainticketbookingsystem.Security.Secure.SignUp;i

public interface AuthenticationService {
    JWTAuthResponse signUp(SignUp signUp);
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse refreshToken(String refreshToken);
    void changePassword(PasswordDto passwordDto);
}
