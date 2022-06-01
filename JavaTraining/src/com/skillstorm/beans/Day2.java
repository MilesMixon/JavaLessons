package com.skillstorm.beans;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

	private List<Animal> animals;
	
	public Day2() {
		animals = new ArrayList<Animal>();
	}
	
	//everything is pass-by-value, but objects are are stored as references (pointers)
	//who's values are passed. You can change values, but cannot reassign them
	public void willChangeValue(Animal animal) {
		animal.name = "Mark";
	}
	
	public void wontChangeValue(Animal animal) {
		animal = new Dog("Mark", "Red", false, false,"??"); //this wont change the original animal
	}
	
	//cannot change primitive values inside of methods
	public int changeValue(int i) {
		i = 75;
		return i;
	}
	
	//wrapper
	//wraps some functionality. the user does not know how it works, or where
	//gives them a defined way to interact with something
	public void save(Animal newAnimal) {
		//does something
	}
	
	public void remove(Animal newAnimal) {
		//does something
	}
	
	public Animal get(int index) {
		return animals.get(index);
	}
}
