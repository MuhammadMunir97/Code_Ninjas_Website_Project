package com.codeninjas.coppell.ninjamanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="game_concepts")
public class GameConcept {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
	private Game game;
	
	@OneToMany(mappedBy="gameConcept", fetch = FetchType.LAZY)
	private List<QuizQuestion> quizQuestions; 
	
	@OneToMany(mappedBy="gameConcept", fetch = FetchType.LAZY)
	private List<GradedGameConcept> gradedGameConcepts;
	
	
	public GameConcept() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	public List<GradedGameConcept> getGradedGameConcepts() {
		return gradedGameConcepts;
	}

	public void setGradedGameConcepts(List<GradedGameConcept> gradedGameConcepts) {
		this.gradedGameConcepts = gradedGameConcepts;
	}
	
	
	
}
