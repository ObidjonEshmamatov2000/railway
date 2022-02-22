package com.mafia.railway_api.entity.railwayConnection;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.entity.railway.RailwayEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "railway_connection_entity")
public class RailwayConnectionEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "railway_id")
    private RailwayEntity railwayEntity;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "connection_railway_connection",
            joinColumns = @JoinColumn(name = "railway_connection"),
            inverseJoinColumns = @JoinColumn(name = "connection_id")
    )
    private List<ConnectionEntity> connectionEntity;


    @Column(name = "is_first")
    private boolean isFirst;

    @Column(nullable = false, name = "ordering")
    private int ordering;

    public RailwayConnectionEntity(boolean isFirst, int ordering) {
        this.isFirst = isFirst;
        this.ordering = ordering;
    }

    public RailwayConnectionEntity() {
    }
}
