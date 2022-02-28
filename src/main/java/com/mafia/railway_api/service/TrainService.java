package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.train.TrainEntity;
import com.mafia.railway_api.exception.train.TrainCustomException;
import com.mafia.railway_api.exception.train.TrainNotFoundException;
import com.mafia.railway_api.model.receive.TrainReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.TrainRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService extends ResponseUtils implements BaseService<TrainReceiveDTO>{
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final TrainRepository trainRepository;

    public void checkTrain(String name, String number) {
        Optional<TrainEntity> by = trainRepository.findTrainEntityByNameAndNumber(name, number);
        if (by.isPresent()) {
            throw new TrainCustomException("train is exist");
        }
    }

    @Override
    public ApiResponse add(TrainReceiveDTO trainReceiveDTO) {
        checkTrain(trainReceiveDTO.getName(), trainReceiveDTO.getNumber());
        TrainEntity map = modelMapper.map(trainReceiveDTO, TrainEntity.class);
        trainRepository.save(map);
        return SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = SUCCESS;
        List<TrainEntity> all = trainRepository.findAll();
        apiResponse.setData(all);
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        ApiResponse apiResponse = SUCCESS;
        Optional<TrainEntity> byId = trainRepository.findById(id);
        if (byId.isEmpty()) {
            throw new TrainNotFoundException("train is not found");
        }
        apiResponse.setData(byId.get());
        return apiResponse;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional<TrainEntity> byId = trainRepository.findById(id);
        if (byId.isEmpty()) {
            throw new TrainNotFoundException("train is not found");
        }
        trainRepository.delete(byId.get());
        return SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, TrainReceiveDTO trainReceiveDTO) {
        Optional<TrainEntity> byId = trainRepository.findById(id);
        if (byId.isEmpty()) {
            throw new TrainNotFoundException("train is not found");
        }
        TrainEntity map = modelMapper.map(trainReceiveDTO, TrainEntity.class);
        trainRepository.save(map);
        return SUCCESS;
    }
}
