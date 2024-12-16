package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DAO.UserDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import com.example.trainticketbookingsystem.Exception.NotFoundException;
import com.example.trainticketbookingsystem.Service.BookingService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceIMPL implements BookingService {

    @Autowired
    private TrainDAO trainDAO;
    @Autowired
    private Mapping mapping;
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        BookingEntity booking =mapping.toBookingEntity(bookingDTO);
        Optional<UserEntity> byEmail = userDAO.findByEmail(bookingDTO.getUserId());

        byEmail.ifPresent(booking::setUser);

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
        if(bookingDAO.existsById(bookingId)){
            BookingEntity booking =bookingDAO.getReferenceById(bookingId);
            List<TrainEntity>trainEntities =booking.getTrains();

            for (TrainEntity train :trainEntities){
                List<BookingEntity>bookingEntities =train.getBookings();
                bookingEntities.remove(booking);
            }
            booking.getTrains().clear();
            bookingDAO.delete(booking);
        }else {
            new NotFoundException("you enterd id not match");
        }
    }

    @Override
    public BookingDTO getBooking(String bookingId) {
            BookingEntity booking =bookingDAO.getReferenceById(bookingId);
            return mapping.toBookingDTO(booking);
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO, String bookingId) {
        Optional<BookingEntity>bookingEntity=bookingDAO.findById(bookingId);
        if (bookingEntity.isPresent()){
            bookingEntity.get().setSeats(bookingDTO.getSeats());
            List<TrainEntity>trainEntities =new ArrayList<>();
            for (String id :bookingDTO.getTrainList()){
                trainEntities.add(trainDAO.getReferenceById(id));
            }
            bookingEntity.get().setTrains(trainEntities);
        }
    }
}
