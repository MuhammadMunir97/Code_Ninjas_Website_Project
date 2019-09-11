package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codeninjas.coppell.ninjamanager.entities.GameConcept;

public interface GameConceptRepository extends CrudRepository<GameConcept, Long>{
	
	public List<GameConcept> findAll();
	public List<GameConcept> findByGameId(Long id);
}
