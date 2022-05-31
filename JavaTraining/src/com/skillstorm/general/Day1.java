package com.skillstorm.general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day1 {
	/*
	 * access modifiers:
	 * 		4 main access modifiers
	 * 		
	 * 		- Public: everything everywhere can access this
	 * 		- Protected: only in the same package or a subclass cna access this
	 * 		- Default: anything within the same package
	 * 		- Private: only within the class
	 */
	// default is when you don't specify an access modifier
	//String name;
	//generally will make these private for encapsulation
	private String name;
	private int id;
	private boolean employed;
	
	//default constructor is only given to an object if you don't define one
	//default constructor is just Object's no argument constructor
	//once i define one i can no longer use the default constructor
	
	//constructors do not have return types and methods do
	public Day1() {
		//no arguments constructor
	}
	
	public Day1(int id, String name) {
		//every constructor in Java must have a first line of either super(), or this()
		//if you type nothing it calls super() under the hood
		super();
		//this();
		
		this.name = name; //this points to whatever instance of a class you are inside of
		this.id = id;
	}
	
	//Bad Practice
//	public void Day1() {
//		System.out.println("I am a method");
//	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEmployed() {
		return employed;
	}
	
	public void setEmployed(boolean employed) {
		this.employed = employed;
	}
	
	public void myMethod() {
		//can access these inside of your class
		name = "Mark";
		id = 8;
	}
	
	public String sayHello() {
		/*
		 * String format specifiers:
		 * 		%t datetime
		 * 		%n newline
		 * 		%f float
		 * 		%e scientific notation
		 * 		%d integer
		 * 		%s string
		 * 		%c character
		 * 		%b boolean
		 */
		
		// return "Hello my name is " + this.name + " and my id is " + this.id;
		return String.format("Hello, my name is %s and my id is %d", name, id);
	}
	
	public List<String> covariantReturn() {
		return new ArrayList<String>();
		//return new LinkedList<String>();
	}
}
