package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;

import com.codeninjas.coppell.ninjamanager.entities.Session;
import com.codeninjas.coppell.ninjamanager.repositories.SessionRepository;

public class SessionService {
	
	private final SessionRepository sessionRepository;

	public SessionService(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	public List<Session> findAllSessionsByNinja(Long id){
		return sessionRepository.findByNinjaId(id);
	}
	
}
