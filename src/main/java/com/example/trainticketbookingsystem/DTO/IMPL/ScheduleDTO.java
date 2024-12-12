package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO implements SuperDTO {
    private String scheduleId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDate date;

    private String trainId;
}
