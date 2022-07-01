package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//needs to set your classes up according to general Java best practices
//for Hibernate to understand
/*
 * Needs: 
 * 	- no args constructor/ default constructor
 * 	- private fields and public getters and setters
 *  - needs to follow name conventions
 *  	- getVariable
 *  	- setVariable
 *  	- isBool
 *  	- setBool
 *  
 * helps to have a toString()
 * 
 * Hibernate is owned by jboss
 */
//jpa: Java Persistence api
@Entity //jpa annotation to tell Java that hibernate manages this
@Table(name = "OWNERS") //tells hibernate what table to look at
public class Owner {
	@Id //needs to tell it this is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//need to tell it this is a column, and need to tell it the column name if it doesnt match
	@Column(name = "name")
	private String name;
	
	@Column
	private String favoriteColor;
	
	@Column
	private String favoriteFood;
	
	@Column
	private int age;
	
	//mapped by the other side of the relation
	@OneToMany(mappedBy = "owner")
	private Set<Vehicle> vehicles; //sets imply no duplicates
	
	public Owner() { }
	
	public Owner(int id, String name, String favoriteColor, String favoriteFood, int age) {
		super();
		this.id = id;
		this.name = name;
		this.favoriteColor = favoriteColor;
		this.favoriteFood = favoriteFood;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFavoriteColor() {
		return favoriteColor;
	}
	
	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	
	public String getFavoriteFood() {
		return favoriteFood;
	}
	
	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", favoriteColor=" + favoriteColor + ", favoriteFood="
				+ favoriteFood + ", age=" + age + ", vehicles=" + vehicles + "]";
	}
}
