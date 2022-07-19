package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Dinosaur;
import com.skillstorm.data.DinosaurRepository;

@Service
public class DinoService {

	@Autowired
	DinosaurRepository repo;
	
	public List<Dinosaur> getDinos() {
		return repo.findAll();
	}
	
	public Dinosaur save(Dinosaur dino) {
		return repo.save(dino);
	}
	
	public Dinosaur find(int id) {
		return repo.findById(id).get();
	}
	
	public List<Dinosaur> findByCriteria(int page, int size) {
		//pagination through spring data jpa. indexing starts at 0
		return repo.findAll(PageRequest.of(page, size)).toList();
	}
}
