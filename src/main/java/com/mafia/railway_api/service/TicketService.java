package com.mafia.railway_api.service;

import com.mafia.railway_api.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;


}
