package com.skillstorm.test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.skillstorm.beans.Sedan;

public class SedanTest {
	private Sedan testCar;
	
//	@Test
//	public void test1() {
//		assertTrue(1 < 2);
//	}
	
	//Never want to test against production information
	//Always want to use test systems that mirror production
	
	@Before
	public void setup() {
		//used to create a fresh set of data
		//setup your database table if testing against a database
		System.out.println("inside the setup method");
		testCar = new Sedan("1998", "Toyota", "Corolla");
	}
	
	@Test
	public void engineStarts() {
		assertEquals("Vroom!", testCar.startEngine());
	}
	
	@Test
	public void hornHonks() {
		assertEquals("Honk!", testCar.honkHorn());
	}
	
	//can test that an exception is thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void displayMileageThrowsIndexOutOfBounds() throws Exception {
		testCar.displayMileage();
	}
}
