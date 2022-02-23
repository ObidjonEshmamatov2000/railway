package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.train.TrainEntity;
import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.train.TrainNotFoundException;
import com.mafia.railway_api.model.receive.TrainReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.TrainRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainService implements BaseService<TrainReceiveDTO> {
    private final ModelMapper modelMapper;
    private final TrainRepository trainRepository;

    @Override
    public ApiResponse add(TrainReceiveDTO trainReceiveDTO) {
        checkTrain(trainReceiveDTO.getNumber());
        TrainEntity map = modelMapper.map(trainReceiveDTO, TrainEntity.class);
        trainRepository.save(map);
        return ResponseUtils.SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = ResponseUtils.SUCCESS;
        apiResponse.setData(trainRepository.findAll());
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        Optional<TrainEntity> optionalTrainEntity = trainRepository.findById(id);
        if (optionalTrainEntity.isEmpty()) {
            throw new TrainNotFoundException("train not found");
        }
        ApiResponse apiResponse = ResponseUtils.SUCCESS;
        apiResponse.setData(optionalTrainEntity.get());
        return apiResponse;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional<TrainEntity> optionalTrainEntity = trainRepository.findById(id);
        if (optionalTrainEntity.isEmpty()) {
            throw new TrainNotFoundException("train not found");
        }
        trainRepository.delete(optionalTrainEntity.get());
        return ResponseUtils.SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, TrainReceiveDTO trainReceiveDTO) {
        Optional<TrainEntity> optionalTrainEntity = trainRepository.findById(id);
        if (optionalTrainEntity.isEmpty()) {
            throw new TrainNotFoundException("train not found");
        }
        TrainEntity map = modelMapper.map(trainReceiveDTO, TrainEntity.class);
        trainRepository.save(map);
        return ResponseUtils.SUCCESS;
    }

    public void checkTrain(String number) {
        Optional<TrainEntity> by = trainRepository.findTrainEntityByNumber(number);
        if (by.isPresent()) {
            throw new RailwayCustomException("train is exist");
        }
    }
}
