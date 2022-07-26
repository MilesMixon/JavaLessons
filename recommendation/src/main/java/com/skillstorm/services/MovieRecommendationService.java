package com.skillstorm.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.skillstorm.models.Movie;

@Service
public class MovieRecommendationService {

	private static final Logger log = Logger.getLogger(MovieRecommendationService.class);
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private String movieApiBaseUrl; //non-hardcoded
	//private String movieApiBaseUrl = "http://localhost:9010"; //HARDCODED
	private String movieApiName = "MOVIE-API";
	
	public Movie findMovieById(int id) {
		//ask eureka where the movies api is
		InstanceInfo instanceInfo = eurekaClient.getApplication(movieApiName).getInstances().get(0);
		this.movieApiBaseUrl = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
		
		RestTemplate restTemplate = new RestTemplate();
		String url = this.movieApiBaseUrl + "/movies/v1/movie/" + id;
		
		//send the request
		ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
		Movie object = response.getBody();
		
		return object;
	}
	
	private Iterable<Movie> findFiveRecommendedMovies(Movie[] movieArray) {
		//algorithm - stonks
		List<Movie> movies = Arrays.asList(movieArray);
		Collections.shuffle(movies);
		LinkedList<Movie> fiveMovies = new LinkedList<>();
		
		for (int i = 0; i < 5; i++) {
			fiveMovies.add(movies.get(i));
		}
		
		return fiveMovies;
	}
	
	public Iterable<Movie> recommendMovies() {	
		//ask eureka where the movies api is
		InstanceInfo instanceInfo = eurekaClient.getApplication(movieApiName).getInstances().get(0);
		this.movieApiBaseUrl = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort();
		
		//make an http call to another service (basically RestSharp)
		RestTemplate template = new RestTemplate();
		ResponseEntity<Movie[]> httpResponse = template.getForEntity(this.movieApiBaseUrl + "/movies/v1", Movie[].class);
		log.info("Movie API returned code: " + httpResponse.getStatusCodeValue());
		Movie[] results = httpResponse.getBody();
		
		return findFiveRecommendedMovies(results);
	}
}
