package com.skillstorm.beans;

public class Library {

	//this is tight coupling
	//private ComicBook comic = new Marvel();
	
	//everyone has to share
	//this is loose coupling
	private ComicBook book;
	
	public void readBook() {
		book.read();
	}
	
	//Spring supports constructor and setter injection
	//this is setter injection
	//needs to follow naming conventions
	public void setBook(ComicBook book) {
		this.book = book;
	}
}
