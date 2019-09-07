package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeninjas.coppell.ninjamanager.entities.CompletedGame;
import com.codeninjas.coppell.ninjamanager.repositories.CompletedGameRepository;

@Service
public class CompletedGameService {
	
	private final CompletedGameRepository completedGameRepo;

	public CompletedGameService(CompletedGameRepository completedGameRepo) {
		this.completedGameRepo = completedGameRepo;
	}
	
	public List<CompletedGame> findAllCompletedGames(){
		return completedGameRepo.findAll();
	}
	
	public CompletedGame findCompletedGameById(Long id) {
		Optional<CompletedGame> completedGame = completedGameRepo.findById(id);
		if(completedGame.isPresent()) {
			return completedGame.get();
		}else {
			return null;
		}
	}
	
	
	
	public List<CompletedGame> findCompGameByNinja(Long id){
		return completedGameRepo.findByNinjaId(id);
	}
	
	public void saveCompletedGame(CompletedGame completedGame) {
		completedGame.getNinja().setStarsAchieved(completedGame.getStarsAchieved() + completedGame.getNinja().getStarsAchieved());
		completedGame.getNinja().setTimeSpentCoding(completedGame.getTimeSpent() + completedGame.getNinja().getTimeSpentCoding());
		completedGameRepo.save(completedGame);
	}
	
	public void deleteCompGameById(Long id) {
		completedGameRepo.deleteById(id);
	}
}
