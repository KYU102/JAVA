package com.codingdojo.JavaBelt.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.JavaBelt.models.NameClass;

@Repository
public interface NameRepository extends CrudRepository<NameClass, Long> {
	
	List<NameClass>findAll();
}
