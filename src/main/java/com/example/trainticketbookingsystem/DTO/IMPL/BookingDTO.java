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
    private LocalDate bookedDate;
    private LocalDate travelDate;
    private String arrivalStation;
    private String departureStation;
    private String passengerClass;
    private int seats;
    private String userId;
    private List<String> trainList;
}
