package com.example.trainticketbookingsystem.Service;

import com.example.trainticketbookingsystem.DTO.IMPL.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    void saveSchedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO>getAllSchedules();
    ScheduleDTO getSchedule(String scheduleId);
    void deleteSchedule(String scheduleId);
    void updateSchedule(ScheduleDTO scheduleDTO,String scheduleId);
}
