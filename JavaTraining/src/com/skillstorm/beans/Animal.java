package com.skillstorm.beans;

import com.skillstorm.general.Day1;

public class Animal {

	//these two are not well encapsulated
	//accessible everywhere
	public String name;
	public String color;
	
	// better encapsulation, but accessible outside the class
	protected boolean fur;
	
	//the most encapsulated
	private boolean tail;
	
	public Animal() { }
	
	public Animal(String name, String color, boolean tail, boolean fur) {
		super();
		this.name = name;
		this.color = color;
		this.tail = tail;
		this.fur = fur;
	}

	public boolean isFur() {
		return fur;
	}

	public void setFur(boolean fur) {
		this.fur = fur;
	}

	public boolean isTail() {
		return tail;
	}

	public void setTail(boolean tail) {
		this.tail = tail;
	}
	
	public String view() {
		return String.format("I am a %s animal, my name is %s, and I am a %s", this.color, this.name, this.getClass().getSimpleName());
	}
	
	//public void myAnimalMethod() {
		//Day1 animalDay1 = new Day1(); //need to import this here because it is a different package
		
		//animalDay1.id = 4; //default is not accessible in a different package
		//animalDay1.name = "new name"; //protected field is not accessible here. not same package or a subclass
		
	//}
}
