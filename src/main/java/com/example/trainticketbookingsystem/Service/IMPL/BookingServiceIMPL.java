package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.PaymentDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DAO.UserDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.PaymentEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import com.example.trainticketbookingsystem.Service.BookingService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BookingServiceIMPL implements BookingService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TrainDAO trainDAO;
    @Autowired
    private PaymentDAO paymentDAO;
    @Autowired
    private Mapping mapping;
    @Autowired
    private BookingDAO bookingDAO;
    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        BookingEntity booking =mapping.toBookingEntity(bookingDTO);
        UserEntity user =userDAO.getReferenceById(bookingDTO.getUserId());
        booking.setUser(user);

        List<TrainEntity>trainEntities =new ArrayList<>();
        for (String id :bookingDTO.getTrainList()){
            if (trainDAO.existsById(id)){
                trainEntities.add(trainDAO.getReferenceById(id));
            }
        }
        booking.setTrains(trainEntities);
        BookingEntity bookingEntity =bookingDAO.save(booking);
            if (bookingEntity==null){
                System.out.println("something went wrong");
            }

    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return null;
    }

    @Override
    public void deleteBooking(String bookingId) {

    }

    @Override
    public void getBooking(String bookingId) {

    }

    @Override
    public void updateBooking(BookingDTO bookingDTO, String bookingId) {

    }
}
