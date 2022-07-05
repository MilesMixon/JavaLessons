package com.skillstorm;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.skillstorm.beans.BooksAMillion;
import com.skillstorm.beans.ComicBook;
import com.skillstorm.beans.DC;
import com.skillstorm.beans.Library;
import com.skillstorm.beans.Marvel;

//instead of using xml we can use a class
// <beans> are defined here
@Configuration
public class ComicStoreConfig {

	//can give the bean aliases, but no longer able to use the 
	//method name if you do this
	@Bean(name = {"Batman", "Superman"})
	//by default all beans are Singletons
	@Scope("prototype") //prototype - you make one default object and just clone that
	public DC comic() {
		//return new Marvel();
		return new DC();
	}
	
	@Bean
//	//there are also shortcut annotations for the scopes
//	@RequestScope
//	@SessionScope
//	@ApplicationScope
	@Primary //prefer this if there is a collision
	public Marvel comic2() {
		return new Marvel();
	}
	
	@Bean
	public BooksAMillion bam() {
		return new BooksAMillion();
	}
	
	@Bean
	public Library library() {
		Library store = new Library();
		store.setBook(comic()); //setter injection
		return store;
	}
}
