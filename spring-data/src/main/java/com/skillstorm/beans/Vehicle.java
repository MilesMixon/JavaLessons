package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String make;
	@Column
	private String model;
	@Column
	private int year;
	@Column
	private String color;
	@Column
	private double price;
	@Column
	private int mileage;
	@Column
	private boolean electric;
	
	@ManyToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;
	
	public Vehicle() { }
	
	public Vehicle(int id, String make, String model, int year, String color, double price, int mileage,
			boolean electric) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
		this.mileage = mileage;
		this.electric = electric;
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
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	public boolean isElectric() {
		return electric;
	}
	
	public void setElectric(boolean electric) {
		this.electric = electric;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "\tVehicle [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", color=" + color
				+ ", price=" + price + ", mileage=" + mileage + ", electric=" + electric + "]\n";
	}
}
