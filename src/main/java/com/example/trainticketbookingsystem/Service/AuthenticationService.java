package com.example.trainticketbookingsystem.Service;

import com.example.demo.DTO.IMPL.PasswordDto;
import com.example.demo.Security.Responce.JWTAuthResponse;
import com.example.demo.Security.Secure.SignIn;
import com.example.demo.Security.Secure.SignUp;

public interface AuthenticationService {
    JWTAuthResponse signUp(SignUp signUp);
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse refreshToken(String refreshToken);
    void changePassword(PasswordDto passwordDto);
}
