package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeninjas.coppell.ninjamanager.entities.Ninja;
import com.codeninjas.coppell.ninjamanager.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public List<Ninja> findAllNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}else {
			return null;
		}
	}
	
	public void saveNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public void deleteNinjaById(Long id) {
		ninjaRepository.deleteById(id);
	}
}
