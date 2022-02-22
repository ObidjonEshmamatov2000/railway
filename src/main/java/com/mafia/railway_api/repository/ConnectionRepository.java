package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<ConnectionEntity, Long> {
    Optional<ConnectionEntity> findConnectionEntityByStation1AndStation2(String station1, String station2);
}
