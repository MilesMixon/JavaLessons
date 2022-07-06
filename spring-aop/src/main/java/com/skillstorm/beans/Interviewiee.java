package com.skillstorm.beans;

import org.springframework.stereotype.Component;

@Component
public class Interviewiee {

	//the idea behind AOP is this class gets to carry on as usual and the aspects
	//do whatever they have to do without this class being aware of them
	public boolean interview() {
		System.out.println("Interviewiee: At the interview");
		
		//throw new NullPointerException();
		return true;
	}
	
	public boolean interwebbed() {
		System.out.println("Interwebbing?");
		
		return true;
	}
	
	public boolean interleaved() {
		System.out.println("Interleaving?");
		
		return true;
	}
	
	public boolean interview(String role) {
		System.out.println("Interviewiee for " + role);
		
		return true;
	}
	
	public int interview(int num, String role) {
		System.out.println("Interviewiee for " + role);
		
		return num;
	}
	
	public int interview(String role, int salary) {
		System.out.println("Interviewiee for " + role + " for $" + salary);
		
		return 1;
	}
	
	public boolean interview(String role, String location) {
		System.out.println("Interviewiee for " + role + " at " + location);
		
		return true;
	}
	
	public int interview(int salary) {
		System.out.println("Interviewiee: At the interview for $" + salary);
		
		return salary;
	}
}
