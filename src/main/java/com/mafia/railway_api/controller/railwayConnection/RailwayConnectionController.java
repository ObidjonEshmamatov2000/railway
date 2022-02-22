package com.mafia.railway_api.controller.railwayConnection;

import com.mafia.railway_api.service.RailwayConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/railway-connection")
public class RailwayConnectionController {
    private final RailwayConnectionService railwayConnectionService;
}
