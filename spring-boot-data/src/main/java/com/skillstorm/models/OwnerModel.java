package com.skillstorm.models;

import java.util.Set;

import com.skillstorm.beans.Owner;

public class OwnerModel {

	private int id;
	private String name;
	private String favoriteColor;
	private String favoriteFood;
	private int age;
	private Set<VehicleModel> vehicles;
	
	public OwnerModel() {
		super();
	}
	
	public OwnerModel(Owner owner) {
		this.id = owner.getId();
		this.name = owner.getName();
		this.favoriteColor = owner.getFavorite_color();
		this.favoriteFood = owner.getFavorite_food();
		this.age = owner.getAge();
	}

	public OwnerModel(int id, String name, String favoriteColor, String favoriteFood, int age) {
		super();
		this.id = id;
		this.name = name;
		this.favoriteColor = favoriteColor;
		this.favoriteFood = favoriteFood;
		this.age = age;
	}
	
	public OwnerModel(int id, String name, String favoriteColor, String favoriteFood, int age,
			Set<VehicleModel> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.favoriteColor = favoriteColor;
		this.favoriteFood = favoriteFood;
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

	public Set<VehicleModel> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<VehicleModel> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "OwnerModel [id=" + id + ", name=" + name + ", favoriteColor=" + favoriteColor + ", favoriteFood="
				+ favoriteFood + ", age=" + age + ", vehicles=" + vehicles + "]";
	}
}
