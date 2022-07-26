package com.skillstorm.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.beans.Movie;
import com.skillstorm.data.MovieRepository;

@RestController
@RequestMapping("/movies/v1")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping
	public ResponseEntity<Iterable<Movie>> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		return new ResponseEntity<Iterable<Movie>>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/movie/{id}")
	public ResponseEntity<Movie> getById(@PathVariable int id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		try {
			return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/movie")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieRepository.save(movie), HttpStatus.CREATED);
	}
}
