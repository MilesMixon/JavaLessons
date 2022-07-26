package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Movie;
import com.skillstorm.services.MovieRecommendationService;

@RestController
@RequestMapping("/recommended/v1")
public class MovieRecommendationController {

	@Autowired
	private MovieRecommendationService movieService;
	
	@GetMapping("/movies")
	public ResponseEntity<Iterable<Movie>> getRecommendedMovies() {
		return new ResponseEntity<Iterable<Movie>>(movieService.recommendMovies(), HttpStatus.OK);
	}
}
