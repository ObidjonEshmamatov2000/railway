package com.mafia.railway_api.entity.user;

import com.mafia.railway_api.entity.BaseEntity;
import com.mafia.railway_api.entity.ticket.TicketEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "user_entity")
public class UserEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String passport;

    @Column(nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private Boolean IsActive=true;

    private String password;

    @OneToMany(mappedBy = "userEntity",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Collection<TicketEntity> ticketEntity;


}
