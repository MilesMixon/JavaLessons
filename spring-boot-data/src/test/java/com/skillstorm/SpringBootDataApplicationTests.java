package com.skillstorm;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.skillstorm.beans.Dinosaur;
import com.skillstorm.services.DinosaurService;

// this annotation fires up your app context and hands it to you
// out of the box this gives you Junit 5 and mockito for mocking. 
// very useful for integration testing
@SpringBootTest
@ActiveProfiles("prod") //can tell it what profile to run as
class SpringBootDataApplicationTests {

	private Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	private DinosaurService service;
	
	@Test
	void dinoServiceFindAllReturnsData() {
		List<Dinosaur> dinos = service.findAll();
		log.info(dinos.toString());
		Assertions.assertNotNull(dinos);
	}

	//i want to undo this every time i run the test
	@Test
	@Transactional //does not normally roll back by default, but does because it's a test method here
	void saveToDatabaseWorks() {
		Dinosaur dino = service.save(new Dinosaur(0, "Crocodile", "Rainbow"));
		log.info(dino.toString());
		Assertions.assertNotEquals(0, dino.getId());
	}
}
