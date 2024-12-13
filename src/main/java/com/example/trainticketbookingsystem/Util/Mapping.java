package com.example.trainticketbookingsystem.Util;

import com.example.trainticketbookingsystem.DTO.IMPL.*;
import com.example.trainticketbookingsystem.Entity.IMPL.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public TrainEntity toTrainEntity(TrainDTO trainDTO){
        return modelMapper.map(trainDTO, TrainEntity.class);
    }
    public TrainDTO toTrainDTO(TrainEntity trainEntity){
        return modelMapper.map(trainEntity, TrainDTO.class);
    }
    public TrainDTO asTrainDTOList(Optional<TrainEntity> trainEntities){
        return modelMapper.map(trainEntities,new TypeToken<List<TrainDTO>>(){}.getType());
    }

    public BookingEntity toBookingEntity(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }
    public BookingDTO toBookingDTO(BookingEntity booking){
        return modelMapper.map(booking, BookingDTO.class);
    }
    public List<BookingDTO>asBookingDTOLIST(List<BookingEntity>bookingEntities){
        return modelMapper.map(bookingEntities,new TypeToken<List<BookingDTO>>(){}.getType());
    }


    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }



    public ScheduleEntity toScheduleEntity(ScheduleDTO scheduleDTO){
        return modelMapper.map(scheduleDTO, ScheduleEntity.class);
    }
    public ScheduleDTO toScheduleDTO(ScheduleEntity scheduleEntity){
        return modelMapper.map(scheduleEntity, ScheduleDTO.class);
    }
    public List<ScheduleDTO>asScheduleDTOLIST(List<ScheduleEntity>scheduleEntities){
        return modelMapper.map(scheduleEntities,new TypeToken<List<ScheduleDTO>>(){}.getType());
    }
    public PaymentEntity toPaymentEntity(PaymentDTO paymentDTO){
        return modelMapper.map(paymentDTO, PaymentEntity.class);
    }
    public PaymentDTO toPaymentDTO(PaymentEntity payment){
        return modelMapper.map(payment, PaymentDTO.class);
    }
    public List<PaymentDTO>asPaymentDTOLIST(List<PaymentEntity>paymentEntities){
        return modelMapper.map(paymentEntities,new TypeToken<List<PaymentDTO>>(){}.getType());
    }

}
