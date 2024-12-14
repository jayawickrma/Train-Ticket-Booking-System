package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Booking")
public class BookingEntity implements SuperEntity {
    @Id
    private String bookingId;
    private LocalDate bookingDate;
    private int seats;

    @ManyToOne
    @JoinColumn(name = "User_email")
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "BookingTrain",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id")
    )
    private List<TrainEntity> trains;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
    private PaymentEntity payment;
}
