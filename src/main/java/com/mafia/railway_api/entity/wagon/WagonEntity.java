package com.mafia.railway_api.entity.wagon;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.ticket.TicketEntity;
import com.mafia.railway_api.entity.train.TrainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class WagonEntity extends BaseEntity {

    @Column(nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "train_id")
    private TrainEntity trainEntity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WagonType wagonType;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private double pricePerKM;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "wagonEntity")
    private List<TicketEntity> ticketEntities;


}
