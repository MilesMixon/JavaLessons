package com.skillstorm.beans;

import java.io.FileNotFoundException;

public class Sedan implements Vehicle {
	private String year;
	private String make;
	private String model;
	
	public Sedan() { }
	
	public Sedan(String year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public boolean validateAge(int age, String action) {
		if (age < 0) {
			throw new IllegalArgumentException("Invalid age");
		}
		switch(action) {
			case "license":
				return age >= 18 ? true : false;
			case "learners":
				return age >= 16 ? true : false;
			case "passenger":
				return true;
			default:
				throw new IllegalArgumentException("Invalid action");
		}
	}
	
	@Override
	public String getInfo() {
		return String.format("I am a %s %s %s", year, make, model);
	}

	@Override
	public String startEngine() {
		return "Vroom!";
	}

	@Override
	public String displayMileage() throws Exception {
		throw new IndexOutOfBoundsException();
		//throw new FileNotFoundException();
	}

	@Override
	public double pumpGas(double gallons) {
		return gallons * 8.50; //takes premium
	}
}
