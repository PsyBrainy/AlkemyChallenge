package com.psybrainy.alkemychallenge.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psybrainy.alkemychallenge.EntityExeption;
import com.psybrainy.alkemychallenge.domain.ProfessorRequest;
import com.psybrainy.alkemychallenge.domain.repository.ProfessorRepository;
import com.psybrainy.alkemychallenge.persistence.crud.ProfessorCrudRepository;
import com.psybrainy.alkemychallenge.persistence.entity.ProfessorEntity;
import com.psybrainy.alkemychallenge.persistence.mapper.ProfessorMapper;

@Repository
public class ProfessorImplRepo implements ProfessorRepository{
	
	@Autowired
    private ProfessorCrudRepository repo;

    @Autowired
    private ProfessorMapper mapper;

	@Override
	public List<ProfessorRequest> getAll() {
		List<ProfessorEntity> professorEntityList = (List<ProfessorEntity>) repo.findAll();

        return professorEntityList
                .stream()
                .map(professorEntity -> mapper.toProfessorRequest(professorEntity))
                .collect(Collectors.toList());
	}

	@Override
	public Optional<ProfessorRequest> getById(Long profId) {
		return Optional.of(repo.findById(profId)
                .map(professor -> mapper.toProfessorRequest(professor))
                .orElseThrow(EntityExeption::new));
	}

	@Override
	public ProfessorRequest save(ProfessorRequest professorRequest) {
		ProfessorEntity professorEntity = mapper.toProfessorEntity(professorRequest);
        return mapper.toProfessorRequest(repo.save(professorEntity));
	}

	@Override
	public void delete(Long profId) {
		repo.deleteById(profId);
		
	}

}
