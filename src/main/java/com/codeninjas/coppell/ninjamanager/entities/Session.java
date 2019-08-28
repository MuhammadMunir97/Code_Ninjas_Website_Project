package com.codeninjas.coppell.ninjamanager.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sessions")
public class Session {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar startedAt;
	private Calendar finishedAt;
	@Lob 
	@Column(name="session_notes", length=600)
	private String sessionNotes;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ninja_id")
	private Ninja ninja;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(Calendar startedAt) {
		this.startedAt = startedAt;
	}
	public Calendar getFinishedAt() {
		return finishedAt;
	}
	public void setFinishedAt(Calendar finishedAt) {
		this.finishedAt = finishedAt;
	}
	public String getSessionNotes() {
		return sessionNotes;
	}
	public void setSessionNotes(String sessionNotes) {
		this.sessionNotes = sessionNotes;
	}
}
