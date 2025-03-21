package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainDTO implements SuperDTO {
    private String trainId;
    private String trainName;
    private String trainImage;
    private String route;
    private Integer capacity;
    private List<String> scheduleIds;
    private List<String> bookingIds;
}
