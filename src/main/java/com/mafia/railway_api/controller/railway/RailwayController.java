package com.mafia.railway_api.controller.railway;

import com.mafia.railway_api.service.RailwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/railway")
public class RailwayController {
    private final RailwayService railwayService;
}
