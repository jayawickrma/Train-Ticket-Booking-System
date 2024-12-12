package com.example.trainticketbookingsystem.Service.IMPL;

import com.example.trainticketbookingsystem.DAO.ScheduleDAO;
import com.example.trainticketbookingsystem.DAO.TrainDAO;
import com.example.trainticketbookingsystem.DTO.IMPL.ScheduleDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.ScheduleEntity;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import com.example.trainticketbookingsystem.Service.ScheduleService;
import com.example.trainticketbookingsystem.Util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ScheduleServiceIMPL implements ScheduleService {
    @Autowired
    private TrainDAO trainDAO;
    @Autowired
    private Mapping mapping;
    @Autowired
    private ScheduleDAO scheduleDAO;
    @Override
    public void saveSchedule(ScheduleDTO scheduleDTO) {

        ScheduleEntity scheduleEntity =mapping.toScheduleEntity(scheduleDTO);
        TrainEntity train =trainDAO.getReferenceById(scheduleDTO.getTrain());
        scheduleEntity.setTrain(train);

        ScheduleEntity schedule =scheduleDAO.save(scheduleEntity);
        if (schedule==null){
            System.out.println("something went wrong");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        return null;
    }

    @Override
    public void getSchedule(String scheduleId) {

    }

    @Override
    public void deleteSchedule(String scheduleId) {

    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO, String scheduleId) {

    }
}
