package com.mafia.railway_api.entity.connection;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.railwayConnection.RailwayConnectionEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "connection_entity")
public class ConnectionEntity extends BaseEntity {

    @Column(name = "station1", nullable = false)
    private String station1;

    @Column(name = "station2", nullable = false)
    private String station2;

    @Column(name = "distance", nullable = false)
    private double distance;

    @Column(name = "commute_coefficient")
    private double commuteCoefficient = 1.0;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "connection_railway_connection",
            inverseJoinColumns = @JoinColumn(name = "railway_connection"),
            joinColumns = @JoinColumn(name = "connection_id")
    )
    @ToString.Exclude
    private List<RailwayConnectionEntity> railwayConnectionEntities;

    public ConnectionEntity() {
    }

    public ConnectionEntity(String station1, String station2, double distance, double commuteCoefficient) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.commuteCoefficient = commuteCoefficient;
    }
}
