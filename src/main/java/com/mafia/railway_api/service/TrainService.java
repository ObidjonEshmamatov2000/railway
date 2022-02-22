package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final ModelMapper modelMapper;
    private final TrainRepository trainRepository;


}
