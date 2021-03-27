package com.psybrainy.alkemychallenge.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.UserEntity;

public interface UserCrudRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String name);
}
