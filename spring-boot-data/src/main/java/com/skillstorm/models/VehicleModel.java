package com.skillstorm.models;

import com.skillstorm.beans.Vehicle;

public class VehicleModel {

	private int id;
	private String make;
	private String model;
	private int year;
	private String color;
	private int ownerId;
	
	public VehicleModel() {
		super();
	}
	
	public VehicleModel(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.make = vehicle.getMake();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
		this.color = vehicle.getColor();
		this.ownerId = vehicle.getOwner().getId();
	}

	public VehicleModel(int id, String make, String model, int year, String color, int ownerId) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.ownerId = ownerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "VehicleModel [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", color=" + color
				+ ", ownerId=" + ownerId + "]";
	}
}
