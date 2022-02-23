package com.mafia.railway_api.service;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.entity.ticket.TicketEntity;
import com.mafia.railway_api.entity.user.UserEntity;
import com.mafia.railway_api.exception.ticket.TicketNotFound;
import com.mafia.railway_api.model.receive.TicketReceiveDTO;
import com.mafia.railway_api.model.response.ApiResponse;
import com.mafia.railway_api.repository.TicketRepository;
import com.mafia.railway_api.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService implements BaseService< TicketReceiveDTO >{
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;


    @Override
    public ApiResponse add(TicketReceiveDTO ticketReceiveDTO) {
        TicketEntity ticketEntity =  modelMapper.map(ticketReceiveDTO, TicketEntity.class);
        ticketRepository.save(ticketEntity);
        return ResponseUtils.SUCCESS;
    }

    @Override
    public ApiResponse getList() {
        ApiResponse apiResponse = ResponseUtils.SUCCESS;
        List< TicketEntity > all = ticketRepository.findAll();
        apiResponse.setData(all);
        return apiResponse;
    }

    @Override
    public ApiResponse get(long id) {
        Optional< TicketEntity > byId = ticketRepository.findById(id);
        if (byId.isEmpty()){
            throw new  TicketNotFound(id+"ticket not found");
        }
        ApiResponse success = ResponseUtils.SUCCESS;
        success.setData(byId.get());
        return success;
    }

    @Override
    public ApiResponse delete(long id) {
        Optional< TicketEntity > byId = ticketRepository.findById(id);
        if (byId.isEmpty()){
            throw new  TicketNotFound(id+"ticket not found");
        }
        ticketRepository.deleteById(id);
        return ResponseUtils.SUCCESS;
    }

    @Override
    public ApiResponse edit(long id, TicketReceiveDTO ticketReceiveDTO) {
        Optional< TicketEntity > byId = ticketRepository.findById(id);
        if (byId.isEmpty()){
            throw new  TicketNotFound(id+"ticket not found");
        }

        TicketEntity ticketEntity=byId.get();
         ticketEntity=modelMapper.map(ticketReceiveDTO,TicketEntity.class);
        ticketRepository.save(ticketEntity);
        ApiResponse success = ResponseUtils.SUCCESS;
        success.setData(ticketEntity);
        return success;
    }
}
