package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.exception.ConnectionCustomException;
import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.ConnectionRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    private final ModelMapper modelMapper;
    private final ConnectionRepository connectionRepository;

    public ApiResponse addConnection(
        ConnectionReceiveDTO connectionReceiveDTO
    ) {
        checkConnection(connectionReceiveDTO.getStation1(), connectionReceiveDTO.getStation2());
        ConnectionEntity map = modelMapper.map(connectionReceiveDTO, ConnectionEntity.class);
        connectionRepository.save(map);
        return ResponseUtils.SUCCESS;
    }

    private void checkConnection(String station1, String station2) {
        Optional<ConnectionEntity> optional = connectionRepository.findConnectionEntityByStation1AndStation2(station1, station2);

        if (optional.isPresent()){
            throw new ConnectionCustomException("the connection is already exist");
        }
    }
}
