package com.psybrainy.alkemychallenge.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.ProfessorEntity;

public interface ProfessorCrudRepository extends CrudRepository<ProfessorEntity, Long> {
}