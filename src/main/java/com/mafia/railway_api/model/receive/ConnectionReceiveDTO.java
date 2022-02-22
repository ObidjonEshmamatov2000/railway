package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConnectionReceiveDTO {

    @JsonProperty("station1")
    private String station1;

    @JsonProperty("station2")
    private String station2;

    private double distance;

    @JsonProperty("commute_coefficient")
    private double commuteCoefficient = 1.0;
}
