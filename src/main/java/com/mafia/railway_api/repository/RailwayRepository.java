package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.railway.RailwayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RailwayRepository extends JpaRepository<RailwayEntity, Long> {
    Optional<RailwayEntity> findByFromStationAndToStation(String fromStation, String toStation);
}
