package com.mafia.railway_api.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketReceiveDTO {
    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("passenger_name")
    private String passengerName;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("end_time")
    private LocalDateTime endTime;

    @JsonProperty("wagon_id")
    private long wagonId;

    @JsonProperty("seat_number")
    private int seatNumber;

    private double price;
    private boolean status;
}
