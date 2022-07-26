package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.beans.Movie;
import com.skillstorm.data.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Optional<Movie> findById(int id) {
		return movieRepository.findById(id);
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
}
