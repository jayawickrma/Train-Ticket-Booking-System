package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.BookingService;
import com.example.trainticketbookingsystem.Service.IMPL.AuthenticationServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/trainBooking/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AuthenticationServiceIMPL authenticationServiceIMPL;

    @PostMapping
    public ResponseEntity<Void>saveBooking(@RequestBody BookingDTO bookingDTO){
        try {
            String UserEmail = authenticationServiceIMPL.getSignedInUserEmail();
            bookingDTO.setUserId(UserEmail);
            bookingService.saveBooking(bookingDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{bookingId}")
    public ResponseEntity<Void>deleteBooking(@PathVariable("bookingId")String bookingId){
        try {
            bookingService.deleteBooking(bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
