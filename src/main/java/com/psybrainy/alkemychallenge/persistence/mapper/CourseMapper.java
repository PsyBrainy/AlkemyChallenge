package com.psybrainy.alkemychallenge.persistence.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psybrainy.alkemychallenge.EntityExeption;
import com.psybrainy.alkemychallenge.domain.CourseRequest;
import com.psybrainy.alkemychallenge.persistence.crud.ProfessorCrudRepository;
import com.psybrainy.alkemychallenge.persistence.entity.CourseEntity;

@Component
public class CourseMapper {


    @Autowired
    private ProfessorCrudRepository crud;

    public CourseRequest toCourseRequest(CourseEntity courseEntity){
        CourseRequest courseRequest = new CourseRequest();

        courseRequest.setCourseID(courseEntity.getCourseID());
        courseRequest.setName(courseEntity.getName());
        courseRequest.setDate(courseEntity.getDate());
        courseRequest.setLimitShare(courseEntity.getLimitShare());
        courseRequest.setProfessor(courseEntity.getProfessor().getProfId());

        return courseRequest;
    }

    public CourseEntity toCourseEntity(CourseRequest courseRequest){

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setCourseID(courseRequest.getCourseID());
        courseEntity.setName(courseRequest.getName());
        courseEntity.setDate(courseRequest.getDate());
        courseEntity.setLimitShare(courseRequest.getLimitShare());
        courseEntity.setProfessor(crud.findById(courseRequest.getProfessor())
                .orElseThrow(EntityExeption::new));

        return courseEntity;
    }
}
