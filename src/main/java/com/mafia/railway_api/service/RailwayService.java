package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.entity.railway.RailwayEntity;
import com.mafia.railway_api.exception.connection.ConnectionNotFoundException;
import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.railway.RailwayNotFoundException;
import com.mafia.railway_api.model.receive.RailwayReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.RailwayRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RailwayService extends ResponseUtils implements BaseService<RailwayReceiveDTO> {
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final RailwayRepository railwayRepository;


    @Override
    public ApiResponse add(RailwayReceiveDTO railwayReceiveDTO) {
        checkRailway(railwayReceiveDTO.getFromStation(), railwayReceiveDTO.getToStation());
        RailwayEntity map = modelMapper.map(railwayReceiveDTO, RailwayEntity.class);
        railwayRepository.save(map);
        return SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = SUCCESS;
        List<RailwayEntity> all = railwayRepository.findAll();
        apiResponse.setData(all);
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        ApiResponse apiResponse = SUCCESS;
        Optional<RailwayEntity> byId = railwayRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayNotFoundException("railway is not found");
        }
        apiResponse.setData(byId.get());
        return apiResponse;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional<RailwayEntity> byId = railwayRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayNotFoundException("railway is not found");
        }
        railwayRepository.delete(byId.get());
        return SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, RailwayReceiveDTO railwayReceiveDTO) {
        Optional<RailwayEntity> byId = railwayRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayNotFoundException("railway is not found");
        }
        RailwayEntity map = modelMapper.map(railwayReceiveDTO, RailwayEntity.class);
        map.setId(id);
        railwayRepository.save(map);
        return SUCCESS;
    }

    public void checkRailway(String from, String to) {
        Optional<RailwayEntity> by = railwayRepository.findByFromStationAndToStation(from, to);
        if (by.isPresent()) {
            throw new RailwayCustomException("connection is exist");
        }
    }
}
