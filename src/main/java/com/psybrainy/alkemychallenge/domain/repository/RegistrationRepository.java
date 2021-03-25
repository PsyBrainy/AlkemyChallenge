package com.psybrainy.alkemychallenge.domain.repository;

import java.util.List;
import java.util.Optional;

import com.psybrainy.alkemychallenge.domain.RegistrationRequest;

public interface RegistrationRepository {
	
	List<RegistrationRequest> getAll();
    Optional<List<RegistrationRequest>> getByStundentDni(String studentDNI);
    Optional<RegistrationRequest> getById(Long regisId);
    RegistrationRequest save(RegistrationRequest registrationRequest);
    void delete(Long regisId);

}
