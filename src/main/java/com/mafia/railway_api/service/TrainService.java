package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.railway.RailwayEntity;
import com.mafia.railway_api.entity.train.TrainEntity;
import com.mafia.railway_api.entity.train.TrainStatus;
import com.mafia.railway_api.entity.wagon.WagonEntity;
import com.mafia.railway_api.model.receive.TrainReceiveDTO;
import com.mafia.railway_api.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final ModelMapper modelMapper;
    private final TrainRepository trainRepository;


    public TrainEntity addTrain(TrainReceiveDTO trainReceiveDTO){
        TrainEntity trainEntity = new TrainEntity();
        trainEntity.setRailwayEntity(new RailwayEntity()); // getRailwayEntity bolishi kerak aslida bu yerda
        trainEntity.setTrainStatus(TrainStatus.valueOf(trainReceiveDTO.getTrainStatus()));
        trainEntity.setName(trainReceiveDTO.getName());
        trainEntity.setSpeed(trainReceiveDTO.getSpeed());
        trainEntity.setStartTime(trainReceiveDTO.getStartTime());
        trainEntity.setUpdatedBy(null);
        trainEntity.setCreatedBy(null);
        trainEntity.setUpdatedDate(null);
        trainRepository.save(trainEntity);
        return trainEntity;
    }

    public List<TrainEntity> getAllTrains(){
        return trainRepository.findAll();
    }

    public TrainEntity getById(long id) {
        return trainRepository.getById(id);
    }

    public TrainEntity update(TrainReceiveDTO trainReceiveDTO) {
        TrainEntity trainEntity = new TrainEntity();
        trainEntity.setRailwayEntity(new RailwayEntity()); // getRailwayEntity bolishi kerak aslida bu yerda----------------
        trainEntity.setTrainStatus(TrainStatus.valueOf(trainReceiveDTO.getTrainStatus()));
        trainEntity.setName(trainReceiveDTO.getName());
        trainEntity.setSpeed(trainReceiveDTO.getSpeed());
        trainEntity.setStartTime(trainReceiveDTO.getStartTime());
        trainEntity.setUpdatedDate(new Date());
        trainEntity.setUpdatedBy(null);
        trainEntity.setCreatedBy(null);

        return trainRepository.save(trainEntity);

    }

    public TrainEntity deleteById(long id) {
        TrainEntity trainEntity = getById(id);
        trainRepository.delete(trainEntity);
        return trainEntity;
    }

}
