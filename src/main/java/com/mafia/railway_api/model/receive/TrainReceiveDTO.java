package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainReceiveDTO{
    private String name;
    private String number;
    private int speed;
    private long railwayId;
    private LocalDateTime startTime;
    private String trainStatus;
}
