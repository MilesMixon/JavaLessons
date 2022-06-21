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
	
	@Override
	public String getInfo() {
		return String.format("I am a %s %s %s", year, make, model);
	}

	@Override
	public String startEngine() {
		return "Vroom!";
	}

	@Override
	public String displayMileage() throws FileNotFoundException {
		//throw new IndexOutOfBoundsException();
		throw new FileNotFoundException();
	}

	@Override
	public double pumpGas(double gallons) {
		return gallons * 8.50; //takes premium
	}
}
