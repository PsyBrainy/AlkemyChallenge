package com.psybrainy.alkemychallenge.domain.repository;

import java.util.List;
import java.util.Optional;

import com.psybrainy.alkemychallenge.domain.ProfessorRequest;

public interface ProfessorRepository {
	
	List<ProfessorRequest> getAll();
    Optional<ProfessorRequest> getById(Long profId);
    ProfessorRequest save(ProfessorRequest professorRequest);
    void delete(Long profId);

}
