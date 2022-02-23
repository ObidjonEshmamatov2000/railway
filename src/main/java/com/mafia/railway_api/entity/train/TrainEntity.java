package com.mafia.railway_api.entity.train;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.railway.RailwayEntity;
import com.mafia.railway_api.entity.wagon.WagonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class TrainEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private int speed;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "railway_id")
    private RailwayEntity railwayEntity;

    private LocalDateTime startTime;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrainStatus trainStatus;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "trainEntity")
    private List<WagonEntity> wagonEntity;
}
