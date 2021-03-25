package com.psybrainy.alkemychallenge.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psybrainy.alkemychallenge.EntityExeption;
import com.psybrainy.alkemychallenge.domain.RegistrationRequest;
import com.psybrainy.alkemychallenge.domain.repository.RegistrationRepository;
import com.psybrainy.alkemychallenge.persistence.crud.RegistrationCrudEntity;
import com.psybrainy.alkemychallenge.persistence.entity.CourseEntity;
import com.psybrainy.alkemychallenge.persistence.entity.CourseRegistrationEntity;
import com.psybrainy.alkemychallenge.persistence.mapper.RegistrationMapper;

@Repository
public class RegistrationImplRepo implements RegistrationRepository{
	
	@Autowired
    private RegistrationCrudEntity repo;

    @Autowired
    private RegistrationMapper mapper;

	@Override
	public List<RegistrationRequest> getAll() {
		
		List<CourseRegistrationEntity> registrationEntities = (List<CourseRegistrationEntity>) repo.findAll();
        
        return registrationEntities
                .stream()
                .map(registrationEntity -> mapper.toRegistrationRequest(registrationEntity))
                .collect(Collectors.toList());
	}

	@Override
	public Optional<RegistrationRequest> getById(Long regisId) {
		return Optional.of(repo.findById(regisId)
                .map(registration -> mapper.toRegistrationRequest(registration))
                .orElseThrow(EntityExeption::new));
	}

	@Override
	public RegistrationRequest save(RegistrationRequest registrationRequest) {
		
		CourseRegistrationEntity registrationEntity = mapper.toRegistrationEntity(registrationRequest);
        CourseEntity courseEntity = registrationEntity.getCourseEntity();
        courseEntity.setLimitShare(courseEntity.getLimitShare() - 1);
        return mapper.toRegistrationRequest(repo.save(registrationEntity));
	}

	@Override
	public void delete(Long regisId) {
		repo.deleteById(regisId);
		
	}

}
