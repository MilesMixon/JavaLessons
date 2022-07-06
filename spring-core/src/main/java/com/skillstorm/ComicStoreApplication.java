package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skillstorm.beans.BooksAMillion;
import com.skillstorm.beans.ComicBook;
import com.skillstorm.beans.DC;
import com.skillstorm.beans.Library;
import com.skillstorm.beans.Link;
import com.skillstorm.beans.Marvel;

public class ComicStoreApplication {

	//Spring handles it's dependency injection through the Spring IOC container
	//IOC: Inversion of Control
	
	public static void main(String[] args) {
		//i would be able to have spring inject in my comic book
		
		//1. initialize Spring, through a config file or class
		//2. IOC container to grab your beans
		// app context made using an xml file in the class path
		// class path: where the app is running -> ClassPathXmlApplicationContext
		// file system: file system native -> FileSystemXmlApplicationContext
		//ApplicationContext context = new ClassPathXmlApplicationContext("ComicStore.xml");
		//ApplicationContext context = new AnnotationConfigApplicationContext(ComicStoreConfig.class);
		
		//always returns a generic object
//		ComicBook comic = (ComicBook) context.getBean("comic");
//		
//		comic.publisherInfo();
//		comic.read();
//		comic.swatFly();
		
//		Library bookstore = (Library) context.getBean("BookStore");
//		bookstore.readBook();
		//can call based off the method or class name
		//ComicBook comic = context.getBean(DC.class);
		//ComicBook comic = (ComicBook) context.getBean("comic2");
		//ComicBook comic = (ComicBook) context.getBean("Batman");
		
//		comic.publisherInfo();
//		comic.read();
//		comic.swatFly();
		
//		System.out.println("---------- DC Comics ----------");
//		System.out.println(context.getBean("Batman"));
//		System.out.println(context.getBean("Batman"));
//		System.out.println(context.getBean("Batman"));
//		System.out.println(context.getBean("Batman"));
//		System.out.println(context.getBean("Batman"));
//		
//		System.out.println("---------- Marvel Comics ----------");
//		System.out.println(context.getBean(Marvel.class));
//		System.out.println(context.getBean(Marvel.class));
//		System.out.println(context.getBean(Marvel.class));
//		System.out.println(context.getBean(Marvel.class));
//		System.out.println(context.getBean(Marvel.class));
		
//		BooksAMillion store = context.getBean(BooksAMillion.class);
//		store.readBook();
		//ApplicationContext context = new AnnotationConfigApplicationContext(ZeldaConfig.class);
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("ZeldaCongig.xml");
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(ZeldaConfig.class);
		
//		System.out.println("Link is in use: " + context.getBean(Link.class));
//		
//		context.close();
	}

}
