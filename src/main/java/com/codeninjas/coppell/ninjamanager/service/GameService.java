package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeninjas.coppell.ninjamanager.entities.Belt;
import com.codeninjas.coppell.ninjamanager.entities.Game;
import com.codeninjas.coppell.ninjamanager.entities.Ninja;
import com.codeninjas.coppell.ninjamanager.repositories.GameRepository;

@Service
public class GameService {
	
	private final GameRepository gameRepository;

	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public List<Game> findAllGames(){
		return gameRepository.findAll();
	}
	
	public Game findGameById(Long id) {
		Optional<Game> game = gameRepository.findById(id);
		if(game.isPresent()) {
			return game.get();
		}else {
			return null;
		}
	}
	
	public List<Game> findByGamesNotInNinja(Ninja ninja){
		return gameRepository.findByNinjasNotContains(ninja);
	}
	
	public List<Game> findByBeltAndNinja(Belt belt , Ninja ninja){
		return gameRepository.findByBeltAndNinjasNotContains(belt, ninja);
	}
	public void saveGame(Game game) {
		gameRepository.save(game);
	}
	
	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}
}
