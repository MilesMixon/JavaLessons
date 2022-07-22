package com.skillstorm.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Owner;
import com.skillstorm.models.OwnerModel;
import com.skillstorm.services.OwnerService;

@RestController
@RequestMapping("/owners/v1")
@CrossOrigin("http://localhost:4200")
public class OwnerController {

	private static final Logger logger = Logger.getLogger(OwnerController.class);
	
	@Autowired
	OwnerService ownerService;
	
	@GetMapping
	public ResponseEntity<List<OwnerModel>> findAll() {
		List<OwnerModel> models = ownerService.findAll();
		logger.debug("Models in controller: " + models);
		
		return new ResponseEntity<List<OwnerModel>>(models, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OwnerModel> findById(@PathVariable int id) {
		return new ResponseEntity<OwnerModel>(ownerService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<OwnerModel> save(@RequestBody OwnerModel newOwner) {
		return new ResponseEntity<OwnerModel>(ownerService.add(newOwner), HttpStatus.CREATED);
	}
}
