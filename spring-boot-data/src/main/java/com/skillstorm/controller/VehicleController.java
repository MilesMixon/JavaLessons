package com.skillstorm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Vehicle;
import com.skillstorm.data.VehicleRepository;

@RestController
@RequestMapping("/vehicles/v1")
@CrossOrigin("http://localhost:4200")
public class VehicleController {

//	@Autowired
//	VehicleRepository repo;
//	
//	@GetMapping
//	public ResponseEntity<List<Vehicle>> findAll() {
//		return new ResponseEntity<List<Vehicle>>(repo.findAll(), HttpStatus.OK);
//	}
}
