package com.example.trainticketbookingsystem.Controller;
import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;
import com.example.trainticketbookingsystem.Exception.DataPersistException;
import com.example.trainticketbookingsystem.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PutMapping(value = "/{trainId}")
    public ResponseEntity<Void>updateTrain(@PathVariable("trainId")String trainId,@RequestBody TrainDTO trainDTO){
        try{
            trainService.updateTrain(trainDTO,trainId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
