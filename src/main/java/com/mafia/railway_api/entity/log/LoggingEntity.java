package com.mafia.railway_api.entity.log;


import com.mafia.railway_api.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class LoggingEntity extends BaseEntity {
    private String message;
}
