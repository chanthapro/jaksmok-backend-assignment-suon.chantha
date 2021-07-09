package com.jaksmok.suonchantha.repository;

import com.jaksmok.suonchantha.infrastructure.repository.BaseRepository;
import com.jaksmok.suonchantha.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);
}
