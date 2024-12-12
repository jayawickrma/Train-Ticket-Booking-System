package com.example.trainticketbookingsystem.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/trainBooking/health")
public class HealthChecker {
    @GetMapping
    public String healthCheck(){
        return "API is working...";
    }
}
