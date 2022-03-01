package com.mafia.railway_api.service;


import com.mafia.railway_api.entity.railwayConnection.RailwayConnectionEntity;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionNotFoundException;
import com.mafia.railway_api.model.receive.RailwayConnectionReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.RailwayConnectionRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RailwayConnectionService extends ResponseUtils implements BaseService<RailwayConnectionReceiveDTO> {
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final RailwayConnectionRepository railwayConnectionRepository;


    @Override
    public ApiResponse add(RailwayConnectionReceiveDTO railwayConnectionReceiveDTO) {
        RailwayConnectionEntity map = modelMapper.map(railwayConnectionReceiveDTO, RailwayConnectionEntity.class);
        railwayConnectionRepository.save(map);
        return SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = SUCCESS;
        List<RailwayConnectionEntity> all = railwayConnectionRepository.findAll();
        apiResponse.setData(all);
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        ApiResponse apiResponse = SUCCESS;
        Optional<RailwayConnectionEntity> byId = railwayConnectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayConnectionNotFoundException("railway connection is not found");
        }
        apiResponse.setData(byId.get());
        return apiResponse;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional<RailwayConnectionEntity> byId = railwayConnectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayConnectionNotFoundException("railway connection is not found");
        }
        railwayConnectionRepository.delete(byId.get());
        return SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, RailwayConnectionReceiveDTO railwayConnectionReceiveDTO) {
        Optional<RailwayConnectionEntity> byId = railwayConnectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RailwayConnectionNotFoundException("railway connection is not found");
        }
        RailwayConnectionEntity map = modelMapper.map(railwayConnectionReceiveDTO, RailwayConnectionEntity.class);
        railwayConnectionRepository.save(map);
        return SUCCESS;
    }
}
