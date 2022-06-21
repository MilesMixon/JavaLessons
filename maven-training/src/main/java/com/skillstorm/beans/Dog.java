package com.skillstorm.beans;

// a Dog is an Animal
public final class Dog extends Animal {

	private String breed;
	
	//functionality from animal is inherited
	public Dog() { }
	
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
	
	public void threadTestMethod() {
		int i = 0;
		
		while (i < 3) {
			System.out.println(name + ": Bark!!! " + i);
			i++;
		}
	}
	
	//overriding
	//changes the functionality, but keeps the method signature the same
	@Override
	public String view() {
		return String.format("My name is %s. Let's play fetch", name);
	}

	@Override
	public String move(int distance) {
		return "Ran " + distance;
	}

	@Override
	public String speak() {
		return "Bark!!";
	}
	
	//overloads can return any values, but need different parameters
	public double speak(int value) {
		// overloaded speak method
		return 2.0;
	}
	
	public String rollOver() {
		return "I did it";
	}
}
