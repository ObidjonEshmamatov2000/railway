package com.mafia.railway_api.entity.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.user.UserEntity;
import com.mafia.railway_api.entity.wagon.WagonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class TicketEntity extends BaseEntity {
    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private UserEntity userEntity;

    @Column(nullable = false)
    private String passengerName;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @JsonIgnore
    @JoinColumn(name = "wagon_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WagonEntity wagonEntity;

    @Column(nullable = false)
    private int seatNumber;

    @Column(nullable = false)
    private double price;

    private boolean status;
}
