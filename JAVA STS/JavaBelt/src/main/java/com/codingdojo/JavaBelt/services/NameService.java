package com.codingdojo.JavaBelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.JavaBelt.models.NameClass;
import com.codingdojo.JavaBelt.repos.NameRepository;



@Service
public class NameService {
	@Autowired
	private NameRepository nameRepository;
	
	public NameService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

	// returns all the books
	public List<NameClass> allNames() {
		return nameRepository.findAll();
	}
	

	// creates a book
	public NameClass createName(NameClass b) {
		return nameRepository.save(b);
	}

	// retrieves a book
	public NameClass findName(Long id) {
		Optional<NameClass> optionalName = nameRepository.findById(id);
		if (optionalName.isPresent()) {
			return optionalName.get();
		} else {
			return null;
		}
	}
	
	//UPDATE
	public NameClass updateName(NameClass b) {
		return nameRepository.save(b);
	}
	
	//DELETE
	public void deleteName(Long id) {
		nameRepository.deleteById(id);
	}
}

