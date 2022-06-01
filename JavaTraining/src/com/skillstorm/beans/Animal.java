package com.skillstorm.beans;

import com.skillstorm.general.Day1;

//final classes cannot be extended, and final  methods cannot be overriden

//can have private methods, but cannot be a private class
public abstract class Animal {
	//abstract classes can have concrete (implemented) methods and 
	//abstract (unimplemented) methods

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
	
	//anything concrete that extends this class needs to implement this
	public abstract void move(int distance);
	
	//abstracted away the implementation
	//the user only has enough information to call the method
	//can return a subclass of the return type when overriding a method
	public abstract String speak();
	
	public String view() {
		return String.format("I am a %s animal, my name is %s, and I am a %s", this.color, this.name, this.getClass().getSimpleName());
	}
	
	//public void myAnimalMethod() {
		//Day1 animalDay1 = new Day1(); //need to import this here because it is a different package
		
		//animalDay1.id = 4; //default is not accessible in a different package
		//animalDay1.name = "new name"; //protected field is not accessible here. not same package or a subclass
		
	//}
}
