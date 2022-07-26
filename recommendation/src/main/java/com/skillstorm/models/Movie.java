package com.skillstorm.models;

//my DTO
public class Movie {

	private int id;
	private String title;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("Movie [id=%s, title=%s]", id, title);
	}
}
