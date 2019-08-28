package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeninjas.coppell.ninjamanager.entities.CompletedGame;

@Repository
public interface CompletedGameRepository extends CrudRepository<CompletedGame, Long>{
	public List<CompletedGame> findAll();
	public List<CompletedGame> findByNinjaId(Long id);
}
