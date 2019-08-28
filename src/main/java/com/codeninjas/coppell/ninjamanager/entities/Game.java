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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Game {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Lob 
	@Column(name="description", length=600)
	private String description;
	
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="belt_id")
	private Belt belt;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "completed_games", 
        joinColumns = @JoinColumn(name = "game_id"), 
        inverseJoinColumns = @JoinColumn(name = "ninja_id")
    )     
	private List<Ninja> ninjas;
	
	@OneToMany(mappedBy="game", fetch = FetchType.LAZY)
	private List<GameConcept> gameConcepts;
	
	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Belt getBelt() {
		return belt;
	}

	public void setBelt(Belt belt) {
		this.belt = belt;
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
