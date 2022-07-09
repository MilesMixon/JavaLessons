package com.skillstorm.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.beans.Owner;

@Repository //is an interface
//need to tell repositories the type to map (in our case owner) and the type of the primary 
//key, both must be objects
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
	//no implementation needed
	
//	@Transactional
//	public Owner save(Owner owner);
	
	//uses the method name to create the implementation
	public List<Owner> findByNameLike(String name);
	
	//can set transactions here
	@Transactional(timeout = 1)
	public List<Owner> findByAgeGreaterThan(int age);
	
	//queries in Spring daat JPA are written in JPQL
	@Query("from Owner o inner join o.vehicles v where v.price > :price")
	public List<Owner> findByPriceGreaterThan(@Param(value = "price") double price);
	
	@Query("from Owner o inner join o.vehicles v where v.price > ?1")
	public List<Owner> findByPriceGreater(double price); //same query as above
}
