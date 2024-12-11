package com.example.trainticketbookingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private List<String>bookings;
}
