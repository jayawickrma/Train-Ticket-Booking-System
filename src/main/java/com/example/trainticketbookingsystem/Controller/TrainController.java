package com.example.trainticketbookingsystem.Controller;

import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.TrainService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/trainBooking/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping
    public ResponseEntity<Void>saveTrain(@RequestBody TrainDTO trainDTO){
        try {
            trainService.saveTrain(trainDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{trainId}")
    public ResponseEntity<Void>deleteTrain(@PathVariable("trainId")String trainId){
        try{
            trainService.deleteTrain(trainId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
