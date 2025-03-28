package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.PaymentDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.PaymentDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.PaymentEntity;
import com.example.trainticketbookingsystem.Service.PaymentService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceIMPL implements PaymentService {
    @Autowired
    private PaymentDAO paymentDAO;
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        PaymentEntity payment =mapping.toPaymentEntity(paymentDTO);
        BookingEntity booking =bookingDAO.getReferenceById(paymentDTO.getBookingId());
        booking.setPayment(payment);
        payment.setBooking(booking);

        PaymentEntity paymentEntity =paymentDAO.save(payment);
            if (paymentEntity==null){
                System.out.println("Something went wrong");
            }
    }

    @Override
    public void deletePayment(String paymentId) {
        if (paymentDAO.existsById(paymentId)) {
            paymentDAO.deleteById(paymentId);
        } else {
            System.out.println("you entered payment Id "+paymentId+" not match");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        List<PaymentDTO>paymentDTOS =new ArrayList<>();
        for (PaymentEntity payment :paymentDAO.findAll()){
            PaymentDTO paymentDTO =mapping.toPaymentDTO(payment);
            paymentDTOS.add(paymentDTO);
        }
        return paymentDTOS;
    }

    @Override
    public PaymentDTO getPayment(String paymentId) {
        PaymentEntity payment =paymentDAO.getReferenceById(paymentId);
        return mapping.toPaymentDTO(payment);
    }

    @Override
    public void UpdatePayment(PaymentDTO paymentDTO, String paymentId) {
        Optional<PaymentEntity>payment =paymentDAO.findById(paymentId);
        if (payment.isPresent()){
            payment.get().setAmount(paymentDTO.getAmount());
        }
    }
}
