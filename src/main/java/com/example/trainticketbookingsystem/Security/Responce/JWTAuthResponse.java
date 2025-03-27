package com.example.trainticketbookingsystem.Security.Responce;

import com.example.trainticketbookingsystem.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTAuthResponse {
    private String tokens;
    private Role role;
}
