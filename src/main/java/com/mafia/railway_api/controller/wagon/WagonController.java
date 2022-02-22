package com.mafia.railway_api.controller.wagon;


import com.mafia.railway_api.service.WagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/wagon")
public class WagonController {
    private final WagonService wagonService;
}
