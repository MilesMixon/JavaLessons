package com.skillstorm.beans;

// a Dog is an Animal
public class Dog extends Animal {

	private String breed;
	
	//functionality from animal is inherited
	
	public Dog(String name, String color, boolean tail, boolean fur, String breed) {
		super(name, color, tail, fur);
		this.breed = breed;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	//overriding
	//changes the functionality, but keeps the method signature the same
	@Override
	public String view() {
		return String.format("My name is %s. Let's play fetch", name);
	}
}
