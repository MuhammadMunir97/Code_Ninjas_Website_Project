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
@Table(name="answers")
public class Answer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quiz_question_id")
	private QuizQuestion quizQuestion;
	
	public Answer () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDescription() {
		return description;
	}

	public void setDescription(Long description) {
		this.description = description;
	}
	
	
}
