package com.psybrainy.alkemychallenge.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.CourseRegistrationEntity;

public interface RegistrationCrudEntity extends CrudRepository<CourseRegistrationEntity,Long> {

}