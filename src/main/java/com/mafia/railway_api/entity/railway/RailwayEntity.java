package com.mafia.railway_api.entity.railway;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.railwayConnection.RailwayConnectionEntity;
import com.mafia.railway_api.entity.train.TrainEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class RailwayEntity extends BaseEntity {
    @Column(nullable = false, name = "from_station")
    private String fromStation;

    @Column(nullable = false, name = "to_station")
    private String toStation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "railwayEntity")
    private List<RailwayConnectionEntity> railwayConnectionEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "railwayEntity")
    private List<TrainEntity> trainEntity;
}
