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
@Table(name="graded_game_concepts")
public class GradedGameConcept {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer starsAchieved;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_concept_id")
	private GameConcept gameConcept;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="completed_game_id")
	private CompletedGame completedGame;
	
	public GradedGameConcept () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStarsAchieved() {
		return starsAchieved;
	}

	public void setStarsAchieved(Integer starsAchieved) {
		this.starsAchieved = starsAchieved;
	}
	
	
}
