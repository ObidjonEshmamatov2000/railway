package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.exception.ConnectionCustomException;
import com.mafia.railway_api.exception.ConnectionNotFound;
import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.ConnectionRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public ApiResponse getConnectionList() {
        ApiResponse apiResponse = ResponseUtils.SUCCESS;
        List<ConnectionEntity> all = connectionRepository.findAll();
        apiResponse.setData(all);
        return apiResponse;
    }

    public ApiResponse deleteConnection(long id) {
        Optional<ConnectionEntity> byId = connectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ConnectionNotFound("connection is not found");
        }
        connectionRepository.delete(byId.get());
        return ResponseUtils.SUCCESS;
    }

    public ApiResponse getConnection(long id) {
        ApiResponse apiResponse = ResponseUtils.SUCCESS;
        Optional<ConnectionEntity> byId = connectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ConnectionNotFound("connection is not found");
        }
        apiResponse.setData(byId.get());
        return apiResponse;
    }

    public ApiResponse editConnection(long id, ConnectionReceiveDTO editingConnectionReceiveDTO) {
        Optional<ConnectionEntity> byId = connectionRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ConnectionNotFound("connection is not found");
        }
        ConnectionEntity map = modelMapper.map(editingConnectionReceiveDTO, ConnectionEntity.class);
        connectionRepository.save(map);
        return ResponseUtils.SUCCESS;
    }

    private void checkConnection(String station1, String station2) {
        Optional<ConnectionEntity> optional1 = connectionRepository.findConnectionEntityByStation1AndStation2(station1, station2);
        Optional<ConnectionEntity> optional2 = connectionRepository.findConnectionEntityByStation1AndStation2(station2, station1);

        if (optional1.isPresent() || optional2.isPresent()){
            throw new ConnectionCustomException("the connection is already exist");
        }
    }
}
