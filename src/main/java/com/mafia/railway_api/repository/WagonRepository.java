package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.wagon.WagonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WagonRepository extends JpaRepository<WagonEntity,Long> {
    Optional<WagonEntity> findWagonEntityByNumber(String number);
}
