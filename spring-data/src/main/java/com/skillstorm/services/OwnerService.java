package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	//can also tell your service that all of it's methods are to be done as transactions
	//only the highest level annotation is applied
	@Transactional(timeout = 10)
	public List<Owner> findByAge(int age) {
		return repository.findByAgeGreaterThan(age);
	}
	
	public List<Owner> findByCarPrice(double price) {
		//return repository.findByPriceGreaterThan(price);
		return repository.findByPriceGreater(price);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Owner add(Owner owner) {
		//return repository.saveAndFlush(owner);
		return repository.save(owner);
	}
}
