package com.codeninjas.coppell.ninjamanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeninjas.coppell.ninjamanager.entities.Belt;
import com.codeninjas.coppell.ninjamanager.repositories.BeltRepository;

@Service
public class BeltService {
	
	private final BeltRepository beltRepository;

	public BeltService(BeltRepository beltRepository) {
		this.beltRepository = beltRepository;
	}
	
	
	public List<Belt> findAllBelts() {
		return beltRepository.findAll();
	}
	
	public Belt findBeltById(Long id) {
		Optional <Belt> belt = beltRepository.findById(id);
		if(belt.isPresent()) {
			return belt.get();
		}else {
			return null;
		}
	}
	
	public void saveBelt(Belt belt) {
		beltRepository.save(belt);
	}
	
	public void deleteBeltById(Long id) {
		beltRepository.deleteById(id);
	}
}
