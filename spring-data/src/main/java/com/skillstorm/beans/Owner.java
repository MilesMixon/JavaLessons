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

@Entity
@Table(name = "owners")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String favoriteColor;
	@Column
	private String favoriteFood;
	@Column
	private int age;
	
	@OneToMany(mappedBy = "owner")
	private Set<Vehicle> vehicles;
	
	public Owner() { }
	
	public Owner(String name, String favoriteColor, String favoriteFood, int age) {
		super();
		//this.id = id;
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
				+ favoriteFood + ", age=" + age + "]\n";
	}
}
