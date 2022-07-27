package com.skillstorm.circuitbreaker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("fallbackUrl/null")
	public ResponseEntity<String> fallbackWithNull() {
		//this is what gets called when the circuit breaker is open
		return new ResponseEntity<String>("I will turn this request right back around young man!", HttpStatus.SERVICE_UNAVAILABLE);
	}
}
