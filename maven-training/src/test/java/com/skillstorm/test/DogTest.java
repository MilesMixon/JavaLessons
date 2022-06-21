package com.skillstorm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.skillstorm.beans.Dog;

//Must have "Test" on the end of the name or they wont run
public class DogTest {

	//test driven development
	//usually you would think to write the code and then write your tests after you have
	//your code created
	//test driven development is the opposite
	//you write the tests first, and then write the code to make the test pass
	private Dog testDog;
	
	//runs before each test
	@Before
	public void setup() {
		//have one value i can always reference for each test
		//setup before every test
		testDog = new Dog("Test", "Blue", true, true, "Husky");
	}
	
	@Test //tells Junit this is a test
	public void dogRollsOver() {
		assertTrue(testDog.rollOver().equalsIgnoreCase("I did it"));		
	}
	
	@Test
	public void dogSpeaks() {
		assertEquals("Bark!!", testDog.speak()); //same as below, but more useful failure output
		//assertTrue(testDog.speak().equalsIgnoreCase("BARK!!!!"));
	}
	
	@Test
	public void dogMoves() {
		assertEquals(String.format("Ran %d", 10), testDog.move(10));
		assertEquals(String.format("Ran %d", 20), testDog.move(20));
		assertEquals(String.format("Ran %d", 5), testDog.move(5));
	}
}
