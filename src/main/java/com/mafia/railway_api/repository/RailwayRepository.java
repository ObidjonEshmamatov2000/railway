package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.railway.RailwayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RailwayRepository extends JpaRepository<RailwayEntity, Long> {
    Optional<RailwayEntity> findByFromStationAndToStation(String fromStation, String toStation);
}
