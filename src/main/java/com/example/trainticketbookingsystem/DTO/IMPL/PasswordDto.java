package com.example.trainticketbookingsystem.DTO.IMPL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDto {
    private String email;
    private String newPassword;
}
