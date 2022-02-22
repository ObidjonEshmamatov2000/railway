package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RailwayConnectionReceiveDTO {
    private long railwayId;
    private long connectionId;
    private boolean isFirst;
    private int ordering;
}
