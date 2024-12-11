package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SheduleEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private TrainEntity train;

}
