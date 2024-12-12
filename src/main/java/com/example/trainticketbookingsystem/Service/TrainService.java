package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;

import java.util.List;

public interface TrainService {
    void saveTrain(TrainDTO trainDTO);
    List<TrainDTO>getAllTrains();
    void deleteTrain(String trainId);
    void getTrain(String trainId);
    void updateTrain(TrainDTO trainDTO,String trainId);
}
