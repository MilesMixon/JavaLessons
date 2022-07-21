package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//DTO is better than sending your same spring data classes to the frontend
@Entity
@Table(name = "owners")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "guid")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column(name = "favoriteColor")
	private String favorite_color;
	@Column(name = "favoriteFood")
	private String favorite_food;
	@Column
	private int age;
	
	@OneToMany(mappedBy = "owner")
	//whichever one has the "mappedby"
	//@JsonIgnore
	//@JsonBackReference("ownerVehicles") // a name you can link to
	private Set<Vehicle> vehicles;
	
	public Owner() { }

	public Owner(int id, String name, String favorite_color, String favorite_food, int age, Set<Vehicle> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.favorite_color = favorite_color;
		this.favorite_food = favorite_food;
		this.age = age;
		this.vehicles = vehicles;
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
	
	public String getFavorite_color() {
		return favorite_color;
	}

	public void setFavorite_color(String favorite_color) {
		this.favorite_color = favorite_color;
	}

	public String getFavorite_food() {
		return favorite_food;
	}

	public void setFavorite_food(String favorite_food) {
		this.favorite_food = favorite_food;
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
		return "Owner [id=" + id + ", name=" + name + ", favorite_color=" + favorite_color + ", favorite_food="
				+ favorite_food + ", age=" + age + ", vehicles=" + vehicles + "]";
	}
}
