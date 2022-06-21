package com.skillstorm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	//this needs to be static
	@BeforeClass
	public static void init() {
		//this is where you would do something like create a database connection
		//maybe even create the database itself
		System.out.println("Before class method");
	}
	
	@Before
	public void setup() {
		//used to create a fresh set of data
		//setup your database table if testing against a database
		System.out.println("inside the Before method");
		testCar = new Sedan("1998", "Toyota", "Corolla");
	}
	
	@Test
	//@Ignore //tells junit not to run the test
	public void engineStarts() {
		assertEquals("Vroom!", testCar.startEngine());
	}
	
	@Test
	@Ignore(value = "Need to update this")
	public void hornHonks() {
		assertEquals("Honk!", testCar.honkHorn());
	}
	
	//can test that an exception is thrown
	@Test(expected = IndexOutOfBoundsException.class)
	public void displayMileageThrowsIndexOutOfBounds() throws Exception {
		testCar.displayMileage();
	}
	
	@Test
	public void canDrive() {
		//edge testing dont test every single value, and just test the ones near the markers
		
		//full license
		assertTrue(testCar.validateAge(19, "license"));
		assertTrue(testCar.validateAge(18, "license"));
		assertFalse(testCar.validateAge(17, "license"));
		
		//learners
		assertTrue(testCar.validateAge(17, "learners"));
		assertTrue(testCar.validateAge(16, "learners"));
		assertFalse(testCar.validateAge(15, "learners"));
		
		//passenger
		assertTrue(testCar.validateAge(15, "passenger"));
		assertTrue(testCar.validateAge(19, "passenger"));
		assertTrue(testCar.validateAge(16, "passenger"));
		assertTrue(testCar.validateAge(18, "passenger"));
		
		//we can reasonably assume every other number works
	}
	
	@After
	public void teardown() {
		//can generally be used to clean up anything created in a before method
		System.out.println("Inside the After method");
		testCar = null;
	}
	
	//this must be static
	@AfterClass
	public static void cleanup() {
		//we would close the database connection here
		System.out.println("After class method");
	}
}
