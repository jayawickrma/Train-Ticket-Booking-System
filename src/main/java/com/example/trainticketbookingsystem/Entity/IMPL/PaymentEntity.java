package com.example.trainticketbookingsystem.Entity.IMPL;

import com.example.trainticketbookingsystem.Entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Payment")
public class PaymentEntity implements SuperEntity {
    @Id
    private String paymentId;

    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentStatus;

    @OneToOne(mappedBy = "payment",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private BookingEntity booking;

}
