package com.skillstorm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Dinosaur;
import com.skillstorm.services.DinosaurService;

@RestController
@RequestMapping("/dinos/v1")
public class DinosaurController {

	private static final Logger logger = Logger.getLogger(DinosaurController.class);
	
	@Autowired
	DinosaurService dinoService;
	
	// base spring -> http://localhost:8080/spring-mvc/dino
	// spring boot -> http://localhost:8080/dino
	@GetMapping
	public ResponseEntity<List<Dinosaur>> getDinos() {
		logger.debug("Find all dinosaurs called");
		return new ResponseEntity<List<Dinosaur>>(dinoService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Dinosaur> save(@RequestBody Dinosaur dino) {
		return new ResponseEntity<Dinosaur>(dinoService.save(dino), HttpStatus.CREATED);
	}
}
