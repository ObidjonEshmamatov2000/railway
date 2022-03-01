package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RailwayConnectionReceiveDTO {
    @JsonProperty("railway_id")
    private long railwayId;

    @JsonProperty("connection_id")
    private long connectionId;

    @JsonProperty("is_first")
    private boolean isFirst;
    private int ordering;
}
