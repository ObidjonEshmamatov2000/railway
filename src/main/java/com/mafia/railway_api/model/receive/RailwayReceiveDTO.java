package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RailwayReceiveDTO {
    @JsonProperty("from_station")
    private String fromStation;

    @JsonProperty("to_station")
    private String toStation;
}
