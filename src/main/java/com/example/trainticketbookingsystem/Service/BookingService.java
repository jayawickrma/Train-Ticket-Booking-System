package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Exception.NotFoundException;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllBookings();
    void deleteBooking(String bookingId);
    void getBooking(String bookingId);
    void updateBooking(BookingDTO bookingDTO ,String bookingId);
}
