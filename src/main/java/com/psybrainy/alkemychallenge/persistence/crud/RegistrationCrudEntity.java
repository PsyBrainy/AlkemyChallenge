package com.psybrainy.alkemychallenge.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.CourseRegistrationEntity;

import java.util.List;
import java.util.Optional;

public interface RegistrationCrudEntity extends CrudRepository<CourseRegistrationEntity,Long> {

    Optional<List<CourseRegistrationEntity>> findByStundentDni(String studentDNI);

}