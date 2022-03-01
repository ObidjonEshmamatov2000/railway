package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.railwayConnection.RailwayConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RailwayConnectionRepository extends JpaRepository<RailwayConnectionEntity, Long> {
}
