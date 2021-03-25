package com.psybrainy.alkemychallenge.domain.repository;

import java.util.List;
import java.util.Optional;

import com.psybrainy.alkemychallenge.domain.CourseRequest;

public interface CourseRepository {

	List<CourseRequest> getAll();
    Optional<CourseRequest> getById(Long couseId);
    Optional<List<CourseRequest>> getCoursesNotRegister(String dniStudent);
    CourseRequest save(CourseRequest courseRequest);
    void delete(Long courseId);
}
