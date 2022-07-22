package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.skillstorm.models.VehicleModel;

@Entity
@Table(name = "vehicles")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "guid")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String make;
	@Column
	private String model;
	//had to change sql setup and column name to account for h2 reserved keywords
	@Column(name = "`year`")
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
	//@JsonManagedReference("ownerVehicles")
	private Owner owner;
	
	public Vehicle() { }
	
	public Vehicle(VehicleModel vehicle) {
		this.id = vehicle.getId();
		this.make = vehicle.getMake();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
		this.color = vehicle.getColor();
		this.price = vehicle.getPrice();
		
		//default values for now, maybe i just dont add them
		this.mileage = 0;
		this.electric = false;
	}
	
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
