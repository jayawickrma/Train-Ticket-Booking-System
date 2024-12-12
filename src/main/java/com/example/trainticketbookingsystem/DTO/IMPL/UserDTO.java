package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements SuperDTO {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    @JsonIgnore
    private List<Long> bookingIds;
}
