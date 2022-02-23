package com.mafia.railway_api.controller.ticket;

import com.mafia.railway_api.model.receive.TicketReceiveDTO;
import com.mafia.railway_api.model.receive.UserReceiveDTO;
import com.mafia.railway_api.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<?> addTicket(
            @Valid @RequestBody TicketReceiveDTO ticketReceiveDTO
            ) {
        return ResponseEntity.ok(ticketService.add(ticketReceiveDTO));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getTicketList(  ) {
        return ResponseEntity.ok(ticketService.getList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable long id  ) {
        return ResponseEntity.ok(ticketService.get(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(
            @PathVariable Long id, @RequestBody TicketReceiveDTO ticketReceiveDTO
    ) {
        return ResponseEntity.ok(ticketService.edit(id,ticketReceiveDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(ticketService.delete(id));
    }
}
