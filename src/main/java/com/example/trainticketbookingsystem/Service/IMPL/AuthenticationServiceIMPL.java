package com.example.trainticketbookingsystem.Service.IMPL;


import com.example.trainticketbookingsystem.DAO.UserDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.PasswordDto;
import com.example.trainticketbookingsystem.DTO.IMPL.UserDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import com.example.trainticketbookingsystem.Exception.NotFoundException;
import com.example.trainticketbookingsystem.Security.Responce.JWTAuthResponse;
import com.example.trainticketbookingsystem.Security.Secure.SignIn;
import com.example.trainticketbookingsystem.Security.Secure.SignUp;
import com.example.trainticketbookingsystem.Service.AuthenticationService;

import com.example.trainticketbookingsystem.Service.JWTService;
import com.example.trainticketbookingsystem.Util.Mapping;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final Mapping mapping;
    private final UserDAO userDao;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public JWTAuthResponse signUp(SignUp signUp) {
        UserDTO userDTO =UserDTO.builder()
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(signUp.getRole())
                .build();
        UserEntity userEntity1 = mapping.toUserEntity(userDTO);
        System.out.println(userEntity1);
        userDao.save(userEntity1);
        System.out.println(userEntity1);
        String generateToken = jwtService.generateToken(userEntity1);
        return JWTAuthResponse.builder().tokens(generateToken).build();
    }

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        UserEntity userEntity=userDao.findByEmail(signIn.getEmail())
                .orElseThrow(()->new NotFoundException("User Not Found"));
        var generateToken =jwtService.generateToken(userEntity);
        System.out.println("==================================  :"+generateToken);
        return JWTAuthResponse.builder().tokens(generateToken).build();

    }

    @Override
    public JWTAuthResponse refreshToken(String refreshToken) {
        String user =jwtService.extractUserName(refreshToken);
        UserEntity findUser =userDao.findByEmail(user).orElseThrow(()-> new NotFoundException("Couldn't find User"));
        String token =jwtService.refreshToken(findUser);
        return JWTAuthResponse.builder().tokens(token).build();
    }

    @Override
    public void changePassword(PasswordDto passwordDto) {
        Optional<UserEntity> byEmail = userDao.findByEmail(passwordDto.getEmail());
        if (byEmail.isPresent()) {
            UserEntity userEntity = userDao.getReferenceById(byEmail.get().getUsername());
            userEntity.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
            userDao.save(userEntity);
        }
    }
    public String getSignedInUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName(); // Returns the email or username (based on your principal configuration)
        }
        throw new IllegalStateException("No authenticated user found");
    }
}