package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.wagon.WagonEntity;
import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.wagon.WagonNotFoundException;
import com.mafia.railway_api.model.receive.WagonReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.WagonRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WagonService implements BaseService<WagonReceiveDTO>{

    private final ModelMapper modelMapper;

    private final WagonRepository wagonRepository;

    private final ResponseUtils responseUtils;

    @Override
    public ApiResponse add(WagonReceiveDTO wagonReceiveDTO) {
        checkWagon(wagonReceiveDTO.getNumber());
        WagonEntity map = modelMapper.map(wagonReceiveDTO, WagonEntity.class);
        wagonRepository.save(map);
        return responseUtils.SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = responseUtils.SUCCESS;
        apiResponse.setData(wagonRepository.findAll());
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        Optional<WagonEntity> optionalWagonEntity = wagonRepository.findById(id);
        if(optionalWagonEntity.isEmpty()){
            throw new WagonNotFoundException("wagon not found");
        }
        ApiResponse apiResponse = responseUtils.SUCCESS;
        apiResponse.setData(optionalWagonEntity);
        return apiResponse;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional<WagonEntity> optionalWagonEntity = wagonRepository.findById(id);
        if(optionalWagonEntity.isEmpty()){
            throw new WagonNotFoundException("wagon not found");
        }
        wagonRepository.delete(optionalWagonEntity.get());
        return responseUtils.SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, WagonReceiveDTO wagonReceiveDTO) {
        Optional<WagonEntity> optionalWagonEntity = wagonRepository.findById(id);
        if(optionalWagonEntity.isEmpty()){
            throw new WagonNotFoundException("wagon not found");
        }
        WagonEntity map = modelMapper.map(wagonReceiveDTO, WagonEntity.class);
        wagonRepository.save(map);
        return responseUtils.SUCCESS;

    }

    public void checkWagon(String number) {
        Optional<WagonEntity> by = wagonRepository.findWagonEntityByNumber(number);
        if (by.isPresent()) {
            throw new RailwayCustomException("wagon is exist");
        }
    }
}
