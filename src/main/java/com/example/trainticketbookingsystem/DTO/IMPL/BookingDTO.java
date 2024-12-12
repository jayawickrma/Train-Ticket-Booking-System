package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO implements SuperDTO {
    private String bookingId;
    private LocalDate bookingDate;
    private Double totalPrice;
    private String userId;
    private List<String> trainList;
}
