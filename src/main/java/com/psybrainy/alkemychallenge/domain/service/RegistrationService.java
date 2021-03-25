package com.psybrainy.alkemychallenge.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psybrainy.alkemychallenge.domain.RegistrationRequest;
import com.psybrainy.alkemychallenge.domain.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
    private RegistrationRepository repo;
	
	
	public List<RegistrationRequest> getAll(){
        return repo.getAll();
    }

    public Optional<RegistrationRequest> getById(Long regisId){
        return repo.getById(regisId);
    }

    public RegistrationRequest save(RegistrationRequest registrationRequest){

        return repo.save(registrationRequest);
    }

    public boolean delete(Long regisId){
        return getById(regisId)
                .map(registration -> {
                    repo.delete(regisId);
                    return true;
                }).orElse(false);
    }

}
