package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.Controller.BookingController;
import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.ScheduleDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.BookingDTO;
import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.BookingEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.ScheduleEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Service.TrainService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class TrainServiceIMPL implements TrainService {
    @Autowired
    private BookingDAO bookingDAO;
    @Autowired
    private Mapping mapping;
    @Autowired
    private ScheduleDAO scheduleDAO;
    @Autowired
    private TrainDAO trainDAO;
    @Override
    public void saveTrain(TrainDTO trainDTO) {

        TrainEntity trainEntity =mapping.toTrainEntity(trainDTO);
        TrainEntity train =trainDAO.save(trainEntity);
        if (train==null){
            System.out.println("something went wrong");
        }

    }

    @Override
    public List<TrainDTO> getAllTrains() {
        return null;
    }

    @Override
    public void deleteTrain(String trainId) {

    }

    @Override
    public void getTrain(String trainId) {

    }

    @Override
    public void updateTrain(TrainDTO trainDTO, String trainId) {

    }
}
