package com.example.trainticketbookingsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDTO {
    private String scheduleId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDate date;
    private  String train;
}
