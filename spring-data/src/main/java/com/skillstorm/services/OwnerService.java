package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Owner;
import com.skillstorm.data.OwnerRepository;

@Service
public class OwnerService {
	
	//need some form of that repository here
	@Autowired
	private OwnerRepository repository;

	public List<Owner> findAll() {
		return repository.findAll();
	}
	
	public List<Owner> findByNameSimilar(String name) {
		return repository.findByNameLike(name);
	}
	
	public List<Owner> findByAge(int age) {
		return repository.findByAgeGreaterThan(age);
	}
}
