package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.Config.SecurityConfig;
import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.PaymentDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DAO.UserDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.UserEntity;
import com.example.trainticketbookingsystem.Exception.NotFoundException;
import com.example.trainticketbookingsystem.Security.Secure.SignIn;
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
    private AuthenticationServiceIMPL authenticationServiceIMPL;
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
    private void sendBookingConfirmationEmail(BookingEntity booking) {
        UserEntity userEmail = booking.getUser(); // Ensure this holds the signed-in user's email
        String subject = "Booking Confirmation";
        String body = String.format("Dear user,\n\nYour booking with ID %d has been successfully created.\n\nDetails:\n%s\n\nThank you for using our service!",
                booking.getUser(), booking.getBookingDetails());
        emailService.sendEmail(userEmail, subject, body);
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
    public void getBooking(String bookingId) {

    }

    @Override
    public void updateBooking(BookingDTO bookingDTO, String bookingId) {

    }
}
