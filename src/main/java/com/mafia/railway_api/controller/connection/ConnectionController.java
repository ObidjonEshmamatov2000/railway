package com.mafia.railway_api.controller.connection;

import com.mafia.railway_api.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/connection")
public class ConnectionController {
    private final ConnectionService connectionService;
}
