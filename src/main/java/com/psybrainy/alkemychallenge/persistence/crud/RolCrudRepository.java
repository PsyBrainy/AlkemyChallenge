package com.psybrainy.alkemychallenge.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.RolEntity;

public interface RolCrudRepository extends CrudRepository<RolEntity, Long> {

    RolEntity findByUserId(Long userId);

}
