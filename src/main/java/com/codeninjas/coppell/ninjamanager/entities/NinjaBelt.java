package com.codeninjas.coppell.ninjamanager.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="ninjas_belts")
public class NinjaBelt {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	private Calendar createdAt;
	private Calendar updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ninja_id")
	private Ninja ninja;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="belt_id")
	private Belt belt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	public Ninja getNinja() {
		return ninja;
	}
	public void setNinja(Ninja ninja) {
		this.ninja = ninja;
	}
	public Belt getBelt() {
		return belt;
	}
	public void setBelt(Belt belt) {
		this.belt = belt;
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
