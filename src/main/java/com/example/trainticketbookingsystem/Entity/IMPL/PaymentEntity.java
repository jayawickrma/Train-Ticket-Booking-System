package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentStatus;

    @OneToOne(mappedBy = "payment")
    private BookingEntity booking;

}
