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
@Table(name="quiz_questions")
public class QuizQuestion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_concept_id")
	private GameConcept gameConcept;
	
	@OneToMany(mappedBy="quizQuestion", fetch = FetchType.LAZY)
	private List<QuizQuestion> quizQuestion;
	
	public QuizQuestion() {
		
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
}
