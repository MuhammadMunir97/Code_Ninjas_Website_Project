package com.codeninjas.coppell.ninjamanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeninjas.coppell.ninjamanager.entities.Belt;

@Repository
public interface BeltRepository extends CrudRepository<Belt, Long>{
	public List<Belt> findAll();
}
