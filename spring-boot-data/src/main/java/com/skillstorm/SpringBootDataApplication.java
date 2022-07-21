package com.skillstorm;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillstorm.beans.Dinosaur;
import com.skillstorm.data.DinosaurRepository;


//spring boot uses starter-pom files that have all of the dependencies you need already
//bundled together and with versions that work together

//spring boot manages the versions for you

//says that this is the starting point of your app
//this file is generally left alone
//this annotation is a composed annotation
//composed of @Configuration, @ComponentScan, and @EnableAutoConfiguration
@SpringBootApplication
public class SpringBootDataApplication implements CommandLineRunner {

//	@Autowired
//	DinosaurRepository repo;
	
	//can have spring boot inject in a logger
	//this creates a logger for this class
	private static final Logger logger = Logger.getLogger(SpringBootDataApplication.class);
	
	public static void main(String[] args) {
		//create creates your app context  for you and configures the app
		SpringApplication.run(SpringBootDataApplication.class, args);
	}

	//whenever app.run finishes starting your app, this runs
	//generally you dont use this
	@Override
	public void run(String... args) throws Exception {
		//you dont console.log in spring boot
		//spring boot gives you a free logger, with timestamps, thread ids, etc
		//System.out.println("App started successfully");
		logger.debug("App started successfully");
		//logger.debug(repo.findAll());
		/*
		 * logging has different severity levels: from highest to lowest
		 * by default im seeing info and up
		 * 		- fatal
		 * 		- error
		 * 		- warn
		 * 		- info
		 * 		- debug
		 * 		- trace 
		 */
	}

}
