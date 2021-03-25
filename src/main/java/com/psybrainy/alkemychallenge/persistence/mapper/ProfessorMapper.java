package com.psybrainy.alkemychallenge.persistence.mapper;

import org.springframework.stereotype.Component;

import com.psybrainy.alkemychallenge.domain.ProfessorRequest;
import com.psybrainy.alkemychallenge.persistence.entity.ProfessorEntity;


@Component
public class ProfessorMapper {
	
	public ProfessorRequest toProfessorRequest(ProfessorEntity professorEntity){
        ProfessorRequest professorRequest = new ProfessorRequest();

        professorRequest.setProfId(professorEntity.getProfId());
        professorRequest.setName(professorEntity.getName());
        professorRequest.setLastName(professorEntity.getLastName());
        professorRequest.setDni(professorEntity.getDni());
        professorRequest.setActive(professorEntity.getActive());

        return professorRequest;
    }

    public ProfessorEntity toProfessorEntity(ProfessorRequest professorRequest){
        ProfessorEntity professorEntity = new ProfessorEntity();

        professorEntity.setProfId(professorRequest.getProfId());
        professorEntity.setName(professorRequest.getName());
        professorEntity.setLastName(professorRequest.getLastName());
        professorEntity.setDni(professorRequest.getDni());
        professorEntity.setActive(professorRequest.getActive());

        return professorEntity;
    }

}
