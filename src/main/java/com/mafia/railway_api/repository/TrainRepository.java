package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.train.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<TrainEntity, Long> {
    Optional<TrainEntity> findTrainEntityByNameAndNumber(String name, String number);
}
