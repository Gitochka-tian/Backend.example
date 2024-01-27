package com.example.SHIZA_BACK.repository;

import com.example.SHIZA_BACK.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
    List<UserEntity> findAllByUsername(String username);
}
