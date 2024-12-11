package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO implements SuperDTO {
    private String paymentId;
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentStatus;
    private String booking;
}
