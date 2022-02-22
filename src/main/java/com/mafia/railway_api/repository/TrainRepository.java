package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.train.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<TrainEntity, Long> {

}
