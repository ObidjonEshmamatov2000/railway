package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.wagon.WagonEntity;
import com.mafia.railway_api.entity.wagon.WagonType;
import com.mafia.railway_api.model.receive.WagonReceiveDTO;
import com.mafia.railway_api.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WagonService {

    private final ModelMapper modelMapper;
    private final WagonRepository wagonRepository;
    private final TrainService trainService;

    public WagonEntity addWagon(WagonReceiveDTO wagonReceiveDTO) {
        WagonEntity wagonEntity = new WagonEntity();
        wagonEntity.setWagonType(WagonType.valueOf(wagonReceiveDTO.getWagonType()));
        wagonEntity.setSize(wagonReceiveDTO.getSize());
        wagonEntity.setTrainEntity(trainService.getById(wagonReceiveDTO.getTrainId()));
        wagonEntity.setPricePerKM(wagonReceiveDTO.getPricePerKM());
        wagonEntity.setCreatedDate(new Date());
        wagonEntity.setUpdatedBy(null);
        wagonEntity.setCreatedBy(null);
        wagonEntity.setUpdatedDate(null);
        return wagonRepository.save(wagonEntity);
    }

    public List<WagonEntity> getAllTrains() {
        return wagonRepository.findAll();
    }

    public WagonEntity getById(long id) {
        return wagonRepository.getById(id);
    }

    public WagonEntity update(WagonReceiveDTO wagonReceiveDTO) {
        WagonEntity wagonEntity = new WagonEntity();
        wagonEntity.setWagonType(WagonType.valueOf(wagonReceiveDTO.getWagonType()));
        wagonEntity.setSize(wagonReceiveDTO.getSize());
        wagonEntity.setTrainEntity(trainService.getById(wagonReceiveDTO.getTrainId()));
        wagonEntity.setPricePerKM(wagonReceiveDTO.getPricePerKM());
        wagonEntity.setUpdatedBy(null);
        wagonEntity.setCreatedBy(null);
        wagonEntity.setUpdatedDate(new Date());
        return wagonRepository.save(wagonEntity);
    }

    public WagonEntity deleteById(long id) {
        WagonEntity wagonEntity = getById(id);
        wagonRepository.delete(wagonEntity);
        return wagonEntity;
    }

}
