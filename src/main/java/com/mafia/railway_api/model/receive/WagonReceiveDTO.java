package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WagonReceiveDTO {
    private String number;

    @JsonProperty("train_id")
    private long trainId;

    @JsonProperty("wagon_type")
    private String wagonType;

    private int size;

    @JsonProperty("price_per_km")
    private double pricePerKM;
}
