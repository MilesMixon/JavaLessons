package com.skillstorm;

import com.skillstorm.beans.Owner;
import com.skillstorm.data.OwnerDAO;

public class HibernateApplication {

	//Hibernate is an ORM
	//ORM: Object Relational Mapper
	public static void main (String[] args) {
		OwnerDAO dao = new OwnerDAO();
		
//		System.out.println("Find all: ");
//		System.out.println(dao.findAll());
		
//		System.out.println("Find by id: ");
//		System.out.println(dao.findById(7));
		
//		Owner newOwner = new Owner(0, "John Mack", "Blue", "Steak", 42);
//		System.out.println("Add an owner: " + newOwner);
//		dao.save(newOwner);
		
		//System.out.println(dao.findBySimilarName("Jo"));
		
		System.out.println(dao.findWithCriteria(1900, 50000, "a"));
		System.out.println(dao.findWithHQL(1900, 50000, "a"));
	}
}
