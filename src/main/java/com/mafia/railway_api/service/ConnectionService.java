package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    private final ModelMapper modelMapper;
    private final ConnectionRepository connectionRepository;


}
