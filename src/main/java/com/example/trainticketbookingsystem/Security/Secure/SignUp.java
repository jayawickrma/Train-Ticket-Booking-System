package com.example.trainticketbookingsystem.Security.Secure;


import com.example.trainticketbookingsystem.Entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUp {
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "weak password")
    private String password;
    @NotNull
    private Role role;

}
