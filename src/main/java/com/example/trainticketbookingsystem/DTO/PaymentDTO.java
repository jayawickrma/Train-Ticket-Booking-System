package com.example.trainticketbookingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentStatus;
    private String booking;
}
