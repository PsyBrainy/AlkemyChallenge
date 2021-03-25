package com.psybrainy.alkemychallenge.persistence.crud;


import org.springframework.data.repository.CrudRepository;

import com.psybrainy.alkemychallenge.persistence.entity.CourseEntity;


public interface CourseCrudRepository extends CrudRepository<CourseEntity, Long> {
	
}
