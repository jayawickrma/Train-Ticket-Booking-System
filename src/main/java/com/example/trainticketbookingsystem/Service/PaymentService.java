package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO paymentDTO);
    void deletePayment(String paymentId);
    List<PaymentDTO> getAllPayment();
    void getPayment(String paymentId);
    void UpdatePayment(PaymentDTO paymentDTO ,String paymentId);
}
