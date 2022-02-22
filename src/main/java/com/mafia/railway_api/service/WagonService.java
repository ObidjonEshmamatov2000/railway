package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WagonService {
    private final ModelMapper modelMapper;
    private final WagonRepository wagonRepository;


}
