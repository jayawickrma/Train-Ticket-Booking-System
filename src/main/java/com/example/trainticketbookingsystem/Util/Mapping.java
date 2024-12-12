package com.example.trainticketbookingsystem.Util;

import com.example.trainticketbookingsystem.DTO.IMPL.TrainDTO;
import com.example.trainticketbookingsystem.Entity.IMPL.TrainEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public List<TrainDTO>asTrainDTOList(List<TrainEntity>trainEntities){
        return modelMapper.map(trainEntities,new TypeToken<List<TrainDTO>>(){}.getType());
    }
}
