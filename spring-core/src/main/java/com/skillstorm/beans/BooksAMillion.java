package com.skillstorm.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BooksAMillion {

	//if i dont want to inject this manually, i can have spring do it
	@Autowired //instead of me controlling how it;s made, i defer that to spring
	// 1. check the type
	// 2. checks the name
	// 3. checks for any other types that could match
	// 4. if none of those it fails
	//@Qualifier("Batman") //can use this to be more specific with auto wiring collisions
	private ComicBook comicBooks;
	
	public void readBook() {
		comicBooks.read();
		comicBooks.swatFly();
	}
	
	public void setComicBooks(ComicBook comic) {
		this.comicBooks = comic;
	}
}
