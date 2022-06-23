package com.codingdojo.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.repositories.DojoRepository;

	@Service
	public class DojoService {
		// adding the book repository as a dependency
		private final DojoRepository dojoRepository;

		public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }

		// returns all the books
		public List<Dojo> allDojos() {
			return dojoRepository.findAll();
		}

		// creates a book
		public Dojo createDojo(Dojo b) {
			return dojoRepository.save(b);
		}

		// retrieves a book
		public Dojo findDojo(Long id) {
			Optional<Dojo> optionalDojo = dojoRepository.findById(id);
			if (optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
		}
		
		//UPDATE
		public Dojo updateDojo(Dojo b) {
			return dojoRepository.save(b);
		}
		
		//DELETE
		public void deleteDojo(Long id) {
			dojoRepository.deleteById(id);
		}
	}

