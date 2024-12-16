package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.DAO.BookingDAO;
import com.example.trainticketbookingsystem.DAO.ScheduleDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
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
import java.util.Optional;

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

        List<ScheduleEntity>scheduleEntities =new ArrayList<>();
        for (String scheduleId : trainDTO.getScheduleIds()){
            if (scheduleDAO.existsById(scheduleId)){
                scheduleEntities.add(scheduleDAO.getReferenceById(scheduleId));
            }
            trainEntity.setSchedules(scheduleEntities);
        }
        TrainEntity train =trainDAO.save(trainEntity);
            if (train == null) {
                System.out.println("Something went wrong");
            }
        }


    @Override
    public List<TrainDTO> getAllTrains() {
        return null;
    }

    @Override
    public void deleteTrain(String trainId) {
        trainDAO.deleteById(trainId);
    }
    @Override
    public TrainDTO getTrain(String trainId) {
        TrainEntity train =trainDAO.getReferenceById(trainId);
        return mapping.toTrainDTO(train);
    }

    @Override
    public void updateTrain(TrainDTO trainDTO, String trainId) {
        Optional<TrainEntity>train =trainDAO.findById(trainId);
        if (train.isPresent()){
            train.get().setTrainName(trainDTO.getTrainName());
            train.get().setRoute(trainDTO.getRoute());
            train.get().setCapacity(trainDTO.getCapacity());
            List<ScheduleEntity>scheduleEntities =new ArrayList<>();
            List<BookingEntity>bookingEntities =new ArrayList<>();

            for (String sid :trainDTO.getScheduleIds()){
                scheduleEntities.add(scheduleDAO.getReferenceById(sid));
            }
            train.get().setSchedules(scheduleEntities);

            for (String bid :trainDTO.getBookingIds()){
                bookingEntities.add(bookingDAO.getReferenceById(bid));
            }
            train.get().setBookings(bookingEntities);
        }
    }
}
