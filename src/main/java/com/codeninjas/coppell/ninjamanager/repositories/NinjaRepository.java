package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeninjas.coppell.ninjamanager.entities.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

	public List<Ninja> findAll();
}
