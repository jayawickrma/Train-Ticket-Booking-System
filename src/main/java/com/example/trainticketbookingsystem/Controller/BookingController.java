package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.BookingService;
import com.example.trainticketbookingsystem.Service.IMPL.AuthenticationServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/trainBooking/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AuthenticationServiceIMPL authenticationServiceIMPL;


    @PostMapping
    public ResponseEntity<Void>saveBooking(@RequestBody BookingDTO bookingDTO){
        System.out.println(bookingDTO);
        try {
            String UserEmail = authenticationServiceIMPL.getSignedInUserEmail();
            bookingDTO.setUserId(UserEmail);
            bookingDTO.setBookedDate(LocalDate.now());
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
    @PutMapping(value = "/{bookingId}")
    public ResponseEntity<Void>updateBooking(@PathVariable("bookingId")String bookingId, @RequestBody BookingDTO booking){
        try{
            bookingService.updateBooking(booking, bookingId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value ="/{bookingId}")
    public BookingDTO getBooking(@PathVariable("bookingId")String bookingId){
         return bookingService.getBooking(bookingId);
    }

    @GetMapping
    public List<BookingDTO> bookingDTOList(){
        System.out.println("req eka awa ============");
        return bookingService.getAllBookings();
    }
//    @GetMapping
//    public List<BookingEntity> getSignedInUsersBookings(){
//        String email =authenticationServiceIMPL.getSignedInUserEmail();
//        return bookingService.getSignedInUsersBookings(email);
//    }
}
