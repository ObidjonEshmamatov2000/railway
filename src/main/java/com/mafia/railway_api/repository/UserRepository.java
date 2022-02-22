package com.mafia.railway_api.repository;

import com.mafia.railway_api.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


}
