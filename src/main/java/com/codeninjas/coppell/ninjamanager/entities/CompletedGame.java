package com.codeninjas.coppell.ninjamanager.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="completed_games")
public class CompletedGame {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int starsAchieved;
	private double timeSpent;
	
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="game_id")
	private Game game;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ninja_id")
	private Ninja ninja;
	
	@OneToMany(mappedBy="completedGame", fetch = FetchType.LAZY)
	private List<GradedGameConcept> gradedGameConcepts;
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Ninja getNinja() {
		return ninja;
	}
	public void setNinja(Ninja ninja) {
		this.ninja = ninja;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getStarsAchieved() {
		return starsAchieved;
	}
	public void setStarsAchieved(int starsAchieved) {
		this.starsAchieved = starsAchieved;
	}
	public double getTimeSpent() {
		return timeSpent;
	}
	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	@PrePersist
	protected void onCreate() {
	  createdAt = Calendar.getInstance();
	}
	@PreUpdate
	protected void onUpdate() {
	  updatedAt = Calendar.getInstance();
	}
}
