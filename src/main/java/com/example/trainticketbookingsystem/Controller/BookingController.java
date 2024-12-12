package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.BookingService;
import com.example.trainticketbookingsystem.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/trainBooking/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Void>saveBooking(@RequestBody BookingDTO bookingDTO){
        try {
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
}
