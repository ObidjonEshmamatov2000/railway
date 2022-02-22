package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.RailwayConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RailwayConnectionService {
    private final ModelMapper modelMapper;
    private final RailwayConnectionRepository railwayConnectionRepository;


}
