package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Train")
public class TrainEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;

    private String trainName;
    private String route;
    private Integer capacity;

    @ManyToMany(mappedBy = "trains")
    private List<BookingEntity> bookings;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<SheduleEntity> schedules;

}
