package com.psybrainy.alkemychallenge.persistence.crud;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psybrainy.alkemychallenge.persistence.entity.CourseEntity;


public interface CourseCrudRepository extends CrudRepository<CourseEntity, Long> {
	
	@Query(value = "SELECT course.* " +
            "FROM course " +
            "WHERE course.date <> ALL (" +
            "SELECT course.date " +
            "FROM course_registration " +
            "RIGHT JOIN course " +
            "ON course_registration.course_id = course.course_id " +
            "WHERE course_registration.stundent_dni = :stundentDni) " +
            "AND course.limit_share > 0", nativeQuery = true)
    Optional<List<CourseEntity>> getCoursesNotRegister(@Param("stundentDni") String dniStudent);
	
}
