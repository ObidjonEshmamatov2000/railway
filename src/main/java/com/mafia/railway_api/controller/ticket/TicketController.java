package com.mafia.railway_api.controller.ticket;

import com.mafia.railway_api.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;
}
