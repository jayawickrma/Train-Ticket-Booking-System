package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.DTO.IMPL.ScheduleDTO;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trainBooking/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>saveSchedule(@RequestBody ScheduleDTO scheduleDTO){
        try{
            scheduleService.saveSchedule(scheduleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{scheduleId}")
    public ResponseEntity<Void>deleteSchedule(@PathVariable("scheduleId")String scheduleId){
        try{
            scheduleService.deleteSchedule(scheduleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{scheduleId}")
    public ResponseEntity<Void>updateSchedule(@PathVariable("scheduleId")String scheduleId,@RequestBody ScheduleDTO scheduleDTO){
        try{
            scheduleService.updateSchedule(scheduleDTO,scheduleId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{scheduleId}")
    public ScheduleDTO getSchedule(@PathVariable("scheduleId")String scheduleId){
        return scheduleService.getSchedule(scheduleId);
    }
    @GetMapping
    public List<ScheduleDTO>getAllSchedules(){
        return scheduleService.getAllSchedules();
    }


}
