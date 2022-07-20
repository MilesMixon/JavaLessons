package com.skillstorm;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.beans.Dinosaur;

@Configuration
public class RestClientConfig {
	
	static String geturl = "http://localhost:8080/spring-mvc/dinos";
	static String posturl = "http://localhost:8080/spring-mvc/dino";

	//in the case of duing api requests, there is one bean we need
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RestClientConfig.class);
		RestTemplate rest = context.getBean(RestTemplate.class);
		
		ResponseEntity<Dinosaur> post = rest.postForEntity(posturl, new Dinosaur(37, "Iguanodon", "black"), Dinosaur.class);
		System.out.println(post.getStatusCode());
		
		HttpHeaders headers = new HttpHeaders();
		post.getHeaders().get("Set-Cookie").stream().forEach(cookie -> {
			headers.set("Cookie", cookie.substring(0, cookie.indexOf(";")));
			System.err.println(headers.getValuesAsList("Cookie"));
		});
		
		//what if i want to send the headers/ cookies i just grabbed with the request
		HttpEntity<Dinosaur[]> entity = new HttpEntity<>(headers);
		ResponseEntity<Dinosaur[]> responseAndHeaders = rest.exchange(geturl, HttpMethod.GET, entity, Dinosaur[].class);
		System.out.println(Arrays.asList(responseAndHeaders.getBody()));
		
		ResponseEntity<Dinosaur[]> response = rest.getForEntity(geturl, Dinosaur[].class);
		System.out.println(Arrays.asList(response.getBody()));
	}

}
