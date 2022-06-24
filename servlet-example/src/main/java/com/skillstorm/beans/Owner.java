package com.skillstorm.beans;

public class Owner {
	private int id;
	private String name;
	private String favoriteColor;
	private String favoriteFood;
	private int age;
	
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

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", favoriteColor=" + favoriteColor + ", favoriteFood="
				+ favoriteFood + ", age=" + age + "]";
	}
}
