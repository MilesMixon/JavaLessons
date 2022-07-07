package com.skillstorm.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Owner;

@Repository //is an interface
//need to tell repositories the type to map (in our case owner) and the type of the primary 
//key, both must be objects
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	//no implementation needed
	
	//uses the method name to create the implementation
	public List<Owner> findByNameLike(String name);
	
	public List<Owner> findByAgeGreaterThan(int age);
}
