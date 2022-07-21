package com.skillstorm.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.beans.Owner;
import com.skillstorm.beans.Vehicle;
import com.skillstorm.data.OwnerRepository;
import com.skillstorm.models.OwnerModel;
import com.skillstorm.models.VehicleModel;

@Service
public class OwnerService {
	
	private static final Logger logger = Logger.getLogger(OwnerService.class);
	
	//need some form of that repository here
	@Autowired
	private OwnerRepository repository;

	public List<OwnerModel> findAll() {
		logger.debug("Grabbing from database");
		List<Owner> owners = repository.findAll();
		logger.debug("returned: " + owners);
		
		List<OwnerModel> models = new LinkedList<>();
		for (Owner owner : owners) {
			OwnerModel temp = new OwnerModel(owner);
			
			Set<VehicleModel> temp2 = new HashSet<>();
			for (Vehicle vehicle : owner.getVehicles()) {
				temp2.add(new VehicleModel(vehicle));
			}
			
			temp.setVehicles(temp2);
			logger.debug("New OwnerModel: " + temp);
			models.add(temp);
		}
		
		return models;
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
