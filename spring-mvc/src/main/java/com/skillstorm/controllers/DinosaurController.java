package com.skillstorm.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.DinoFavorites;
import com.skillstorm.beans.Dinosaur;
import com.skillstorm.services.DinoService;

//how to bypass the view resolver
//@Controller
//@ResponseBody //now this annotation applies to the entire controller
@RestController //this is a composed annotation. it composes @Controller & @ResponseBody
public class DinosaurController {

	@Autowired
	DinoService dinoService;
	
	@Autowired
	DinoFavorites favService;
	
	//@RequestMapping(path = "/dino", method = RequestMethod.GET)
	@GetMapping("/dinos/criteria")
	//@ResponseBody //this bypasses the view resolver
	//tells spring to append whatever is returned to the body of the http response
	//by default it's json
	// /dino?page=val&size=val
	//can make all of these optional
	public List<Dinosaur> getDino(@RequestParam int page, @RequestParam int size) {
		//this is not a view, so i dont want it to go to the view resolver
		return dinoService.findByCriteria(page, size);
		//return new Dinosaur(0, page+"", size+"");
	}
	
	//@RequestMapping(path = "/dinos", method = RequestMethod.GET)
	@GetMapping("/dinos")
	//@ResponseBody
	public ResponseEntity<List<Dinosaur>> getAllDinos() {
		
		return ResponseEntity.ok(dinoService.getDinos());
		//return dinoService.getDinos();
	}
	
	@GetMapping("/dinos/{id}/{name}")
	//id comes from the path, if the names match i dont need to tell it the name
	public Dinosaur getDino(@PathVariable int id, @PathVariable String name) {
		//System.out.println("name: " + name);
		return dinoService.find(id);
	}
	
	@GetMapping("/favorites")
	public ResponseEntity<List<Dinosaur>> getFavs() {
		return new ResponseEntity<List<Dinosaur>>(favService.getDinos(), HttpStatus.OK);
	}
	
	@PostMapping("/dinos")
	//i am being handed a new dinosaur in the request and would like to access it
	//can do that with the @RequestBody annotation
	public ResponseEntity<Dinosaur> addDino(@Valid @RequestBody Dinosaur dino) {
		//can use this to pre-validate your incoming json
		//return dino;
		favService.add(dino);
		
		ResponseEntity<Dinosaur> response = new ResponseEntity<Dinosaur>(dinoService.save(dino), HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/cookie")
	public void getCookie(HttpServletRequest req, HttpServletResponse res) {
		//spring can inject the request and response for me
		
		//Spring doesnt have a way to ADD cookies, so we do that through servlets
		res.addCookie(new Cookie("Dan", "Pickles"));
		res.addCookie(new Cookie("Oatmeal", "Raisin"));
	}
	
	@GetMapping("/cookieVal")
	public String cookieValue(@CookieValue(name = "Dan") String cookie1, 
			@CookieValue(name = "Miles", required = false, defaultValue = "Chocolate Chip") String cookie2) {
		return cookie1 + " " + cookie2;
	}
	
}
