package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllBookings();
    void deleteBooking(String bookingId);
    BookingDTO getBooking(String bookingId);
//    List<BookingEntity> getSignedInUsersBookings(String email);
    void updateBooking(BookingDTO bookingDTO ,String bookingId);
}
