package com.psybrainy.alkemychallenge.persistence.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psybrainy.alkemychallenge.EntityExeption;
import com.psybrainy.alkemychallenge.domain.RegistrationRequest;
import com.psybrainy.alkemychallenge.persistence.crud.CourseCrudRepository;
import com.psybrainy.alkemychallenge.persistence.entity.CourseRegistrationEntity;

@Component
public class RegistrationMapper {


    @Autowired
    private CourseCrudRepository crud;

    public RegistrationRequest toRegistrationRequest(CourseRegistrationEntity registrationEntity){
        RegistrationRequest registrationRequest = new RegistrationRequest();

        registrationRequest.setRegistrationId(registrationEntity.getRegistrationId());
        registrationRequest.setStudentFile(registrationEntity.getStudentFile());
        registrationRequest.setStundentDni(registrationEntity.getStundentDni());
        registrationRequest.setCourseRequest(registrationEntity.getCourseEntity().getCourseID());

        return registrationRequest;
    }

    public CourseRegistrationEntity toRegistrationEntity(RegistrationRequest registrationRequest){
        CourseRegistrationEntity registrationEntity = new CourseRegistrationEntity();

        registrationEntity.setRegistrationId(registrationRequest.getRegistrationId());
        registrationEntity.setStudentFile(registrationRequest.getStudentFile());
        registrationEntity.setStundentDni(registrationRequest.getStundentDni());
        registrationEntity.setCourseEntity(crud.findById(registrationRequest.getCourseRequest())
                .orElseThrow(EntityExeption::new));

        return registrationEntity;
    }

}
