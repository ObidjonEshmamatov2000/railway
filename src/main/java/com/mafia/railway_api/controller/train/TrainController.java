package com.mafia.railway_api.controller.train;

import com.mafia.railway_api.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/train")
public class TrainController {
    private final TrainService trainService;
}
