package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Schedule")
public class ScheduleEntity implements SuperEntity {
    @Id
    private String scheduleId;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private TrainEntity train;

}
