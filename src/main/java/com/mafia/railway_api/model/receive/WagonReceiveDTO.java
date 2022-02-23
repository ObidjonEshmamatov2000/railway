package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WagonReceiveDTO {
    private String number;
    private long trainId;
    private String wagonType;
    private int size;
    private double pricePerKM;
}
