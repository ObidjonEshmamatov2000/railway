package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.RailwayRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RailwayService {
    private final ModelMapper modelMapper;
    private final RailwayRepository railwayRepository;


}
