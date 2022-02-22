package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.connection.ConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<ConnectionEntity, Long> {
}
