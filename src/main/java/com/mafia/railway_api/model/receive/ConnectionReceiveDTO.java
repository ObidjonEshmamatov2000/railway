package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConnectionReceiveDTO {

    private String station1;
    private String station2;
    private double distance;
    private double commuteCoefficient = 1.0;
}
