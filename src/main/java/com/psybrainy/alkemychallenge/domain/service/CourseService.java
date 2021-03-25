package com.psybrainy.alkemychallenge.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psybrainy.alkemychallenge.domain.CourseRequest;
import com.psybrainy.alkemychallenge.domain.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public List<CourseRequest> getAll(){
        return repo.getAll();
    }

    public Optional<CourseRequest> getById(Long couseId){
        return repo.getById(couseId);
    }

    public Optional<List<CourseRequest>> getCoursesNotRegister(String dniStudent){
        return repo.getCoursesNotRegister(dniStudent);
    }

    public CourseRequest save(CourseRequest courseRequest){
        return repo.save(courseRequest);
    }

    public boolean delete(Long courseId){
        return getById(courseId)
                .map(courseRequest -> {
                    repo.delete(courseId);
                    return true;
                }).orElse(false);
    }
}
