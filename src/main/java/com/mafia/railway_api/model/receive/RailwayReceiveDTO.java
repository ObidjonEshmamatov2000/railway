package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RailwayReceiveDTO {
    private String fromStation;
    private String toStation;
}
