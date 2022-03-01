package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("railway_id")
    private long railwayId;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("train_status")
    private String trainStatus;
}
