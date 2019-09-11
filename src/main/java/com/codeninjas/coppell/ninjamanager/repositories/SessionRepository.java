package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codeninjas.coppell.ninjamanager.entities.Session;

public interface SessionRepository extends CrudRepository<Session, Long> {

	public List<Session> findAll();
	public List<Session> findByNinjaId(Long id);
}
