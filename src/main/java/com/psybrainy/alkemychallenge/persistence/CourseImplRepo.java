package com.psybrainy.alkemychallenge.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psybrainy.alkemychallenge.domain.CourseRequest;
import com.psybrainy.alkemychallenge.domain.repository.CourseRepository;
import com.psybrainy.alkemychallenge.persistence.crud.CourseCrudRepository;
import com.psybrainy.alkemychallenge.persistence.entity.CourseEntity;
import com.psybrainy.alkemychallenge.persistence.mapper.CourseMapper;

@Repository
public class CourseImplRepo implements CourseRepository {
	
	@Autowired
    private CourseCrudRepository courseRepo;

    @Autowired
    private CourseMapper mapper;

	@Override
	public List<CourseRequest> getAll() {
		
		List<CourseEntity> courseEntityList = (List<CourseEntity>) courseRepo.findAll();

        return courseEntityList
                .stream()
                .map(courseEntity -> mapper.toCourseRequest(courseEntity))
                .collect(Collectors.toList());
	}

	@Override
	public Optional<CourseRequest> getById(Long couseId) {
		return courseRepo.findById(couseId)
                .map(course -> mapper.toCourseRequest(course));
	}

	@Override
	public Optional<List<CourseRequest>> getCoursesNotRegister(String dniStudent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseRequest save(CourseRequest courseRequest) {
		CourseEntity courseEntity = mapper.toCourseEntity(courseRequest);
        return mapper.toCourseRequest(courseRepo.save(courseEntity));
	}

	@Override
	public void delete(Long courseId) {
		courseRepo.deleteById(courseId);
	}

}
