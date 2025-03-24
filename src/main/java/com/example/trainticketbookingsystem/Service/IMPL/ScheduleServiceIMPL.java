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

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
      if (trainDAO.existsById(scheduleDTO.getTrainId())){
          TrainEntity train =trainDAO.getReferenceById(scheduleDTO.getTrainId());
          scheduleEntity.setTrain(train);
        }

      ScheduleEntity schedule =scheduleDAO.save(scheduleEntity);
        if (schedule==null){
            System.out.println("something went wrong");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO>scheduleDTOS =new ArrayList<>();
        List<ScheduleEntity>scheduleEntities = scheduleDAO.findAll();
            for (ScheduleEntity schedule :scheduleEntities){
                ScheduleDTO scheduleDTO =mapping.toScheduleDTO(schedule);
                    if (schedule.getTrain()!=null){
                            String trainName =schedule.getTrain().getTrainName();
                            scheduleDTO.setTrainId(trainName);
                    }
                    scheduleDTOS.add(scheduleDTO);
            }
            return scheduleDTOS;
    }

    @Override
    public ScheduleDTO getSchedule(String scheduleId) {
        ScheduleEntity schedule =scheduleDAO.getReferenceById(scheduleId);
        return mapping.toScheduleDTO(schedule);
    }

    @Override
    public void deleteSchedule(String scheduleId) {
            scheduleDAO.deleteById(scheduleId);
    }

    @Override
    public void updateSchedule(ScheduleDTO scheduleDTO, String scheduleId) {
        Optional<ScheduleEntity>scheduleEntity =scheduleDAO.findById(scheduleId);
        if (scheduleEntity.isPresent()){
            scheduleEntity.get().setTrain(trainDAO.getReferenceById(scheduleDTO.getTrainId()));
            scheduleEntity.get().setArrivalTime(scheduleDTO.getArrivalTime());
            scheduleEntity.get().setDepartureTime(scheduleDTO.getDepartureTime());
        }
    }
}
