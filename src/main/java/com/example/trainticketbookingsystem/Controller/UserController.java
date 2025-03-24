package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.Security.Responce.JWTAuthResponse;
import com.example.trainticketbookingsystem.Security.Secure.SignIn;
import com.example.trainticketbookingsystem.Security.Secure.SignUp;
import com.example.trainticketbookingsystem.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/trainBooking/auth")
@CrossOrigin
public class UserController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthResponse> signIN(@RequestBody SignIn signIn){
        System.out.println("sign in unaaa");
        return ResponseEntity.ok(authenticationService.signIn(signIn));
    }
    @PostMapping("/signUp")
    public ResponseEntity<JWTAuthResponse> saveUser(@RequestBody SignUp signUp){
        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }
}
