//package com.example.trainticketbookingsystem.Util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigForPublicAccess {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        // Allow access to the specific schedule endpoint without authentication
//                        .requestMatchers("/api/schedules/{scheduleId}").permitAll()
//                        // Other public endpoints
//                        .requestMatchers("/auth/**", "/public/**").permitAll()
//                        // All other endpoints require authentication
//                        .anyRequest().authenticated()
//                );
//
//        // Add your JWT configuration, etc.
//
//        return http.build();
//    }
//}