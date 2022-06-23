package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

	// returns all the books
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	// creates a book
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}

	// retrieves a book
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	//UPDATE
	public Ninja updateNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	
	//DELETE
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
}
