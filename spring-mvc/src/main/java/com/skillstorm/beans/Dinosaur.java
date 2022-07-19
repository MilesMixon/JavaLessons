package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dinosaur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String color;
	
	public Dinosaur() {
//		this.id = 1;
//		this.name = "pterodactyl";
//		this.color = "green";
	}

	public Dinosaur(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dinosaur [id=" + id + ", name=" + name + ", color=" + color + "]";
	}
}
