package com.example.trainticketbookingsystem.DTO.IMPL;

import com.example.trainticketbookingsystem.DTO.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainDTO implements SuperDTO {
    private String trainId;
    private String trainName;
    private String route;
    private int capacity;
    private List<String>bookings;
    private List<String>schedules;

}
