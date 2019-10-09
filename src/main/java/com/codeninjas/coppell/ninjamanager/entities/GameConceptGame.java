package com.codeninjas.coppell.ninjamanager.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="game_concept_games")
public class GameConceptGame {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
	private Game game;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_concept_id")
	private GameConcept gameConcept;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameConcept getGameConcept() {
		return gameConcept;
	}

	public void setGameConcept(GameConcept gameConcept) {
		this.gameConcept = gameConcept;
	}
	
	
}
