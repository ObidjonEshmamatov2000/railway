package com.mafia.railway_api.controller.connection;

import com.mafia.railway_api.model.receive.ConnectionReceiveDTO;
import com.mafia.railway_api.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {
    private final ConnectionService connectionService;

    @PostMapping("/add")
    public ResponseEntity<?> addConnection(
            @Valid @RequestBody ConnectionReceiveDTO connectionReceiveDTO
            ) {
        return ResponseEntity.ok(connectionService.addConnection(connectionReceiveDTO));
    }
}
