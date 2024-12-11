package com.example.trainticketbookingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    private String bookingId;
    private LocalDate bookingDate;
    private Double totalPrice;
    private String user;
    private List<String>trainList;
    private String paymentId;

}
