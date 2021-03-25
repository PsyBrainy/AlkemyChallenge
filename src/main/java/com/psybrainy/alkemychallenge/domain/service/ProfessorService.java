package com.psybrainy.alkemychallenge.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psybrainy.alkemychallenge.domain.ProfessorRequest;
import com.psybrainy.alkemychallenge.domain.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
    private ProfessorRepository repo;
	
	public List<ProfessorRequest> getAll(){
        return repo.getAll();
    }

    public Optional<ProfessorRequest> getById(Long profId){
        return repo.getById(profId);
    }

    public ProfessorRequest save(ProfessorRequest professorRequest){
        return repo.save(professorRequest);
    }

    public boolean delete(Long profId){
        return getById(profId)
                .map(professorRequest -> {
                    repo.delete(profId);
                    return true;
                }).orElse(false);
    }

}
