package com.mafia.railway_api.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketReceiveDTO {
    private long userId;
    private String passengerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long wagonId;
    private int seatNumber;
    private double price;
    private boolean status;
}
