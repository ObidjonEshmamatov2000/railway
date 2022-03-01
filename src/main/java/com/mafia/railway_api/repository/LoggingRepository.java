package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import com.mafia.railway_api.entity.log.LoggingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoggingRepository extends JpaRepository<LoggingEntity, Long> {
}
