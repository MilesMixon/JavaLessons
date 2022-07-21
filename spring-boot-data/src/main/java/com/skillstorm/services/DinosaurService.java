package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Dinosaur;
import com.skillstorm.data.DinosaurRepository;

@Service
public class DinosaurService {

	@Autowired
	DinosaurRepository repo;
	
	public List<Dinosaur> findAll() {
		return repo.findAll();
	}
	
	public Dinosaur save(Dinosaur dino) {
		return repo.save(dino);
	}
}
