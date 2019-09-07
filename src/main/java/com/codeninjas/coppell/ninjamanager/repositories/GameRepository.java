package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeninjas.coppell.ninjamanager.entities.Belt;
import com.codeninjas.coppell.ninjamanager.entities.CompletedGame;
import com.codeninjas.coppell.ninjamanager.entities.Game;
import com.codeninjas.coppell.ninjamanager.entities.Ninja;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	public List<Game> findAll();
	public List<Game> findByBeltAndNinjasNotContains(Belt belt , Ninja ninja);
}
