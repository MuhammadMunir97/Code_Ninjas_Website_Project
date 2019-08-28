package com.codeninjas.coppell.ninjamanager.entities;

import java.util.ArrayList;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private Double timeSpentCoding;
	private int starsAchieved;
	
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	public Ninja() {
		belt = new ArrayList<>();
		session = new ArrayList<>();
		games = new ArrayList<>();
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ninjas_belts", 
        joinColumns = @JoinColumn(name = "ninja_id"), 
        inverseJoinColumns = @JoinColumn(name = "belt_id")
    )     
    private List<Belt> belt;
	
	@OneToMany(mappedBy="ninja", fetch = FetchType.LAZY)
	private List<Session> session;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "completed_games", 
        joinColumns = @JoinColumn(name = "ninja_id"), 
        inverseJoinColumns = @JoinColumn(name = "game_id")
    )     
	public List<Game> games;
	
	public List<Belt> getBelt() {
		return belt;
	}
	public void setBelt(Belt belt) {
		this.belt.add(belt);
	}
	public List<Session> getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session.add(session);
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(Game games) {
		this.games.add(games);
	}
	public int getStarsAchieved() {
		return starsAchieved;
	}
	public void setStarsAchieved(int starsAchieved) {
		this.starsAchieved = starsAchieved;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getTimeSpentCoding() {
		return timeSpentCoding;
	}
	public void setTimeSpentCoding(Double timeSpentCoding) {
		this.timeSpentCoding = timeSpentCoding;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
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