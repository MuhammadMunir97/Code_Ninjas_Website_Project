package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeninjas.coppell.ninjamanager.entities.GameConcept;
import com.codeninjas.coppell.ninjamanager.repositories.GameConceptRepository;

@Service
public class GameConceptService {
	
	private final GameConceptRepository gameConceptRepository;

	public GameConceptService(GameConceptRepository gameConceptRepository) {
		this.gameConceptRepository = gameConceptRepository;
	}
	
	public List<GameConcept> findAll(){
		return gameConceptRepository.findAll();
	}
	
	public List<GameConcept> findByGameId(Long id){
		return gameConceptRepository.findByGamesId(id);
	}
	
	public void saveGameConcept(GameConcept gameConcept) {
		gameConceptRepository.save(gameConcept);
	}
	
	public void deleteGameConcept(Long id) {
		gameConceptRepository.deleteById(id);
	}
}
