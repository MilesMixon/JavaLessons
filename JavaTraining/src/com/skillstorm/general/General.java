package com.skillstorm.general;
// single line comment
/*
  multi line comment
  this can span multiple lines
  
  anything in a comment is ignored by your compiler
 */

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Animal;
import com.skillstorm.beans.Cat;
import com.skillstorm.beans.Day2;
import com.skillstorm.beans.Dog;
import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Truck;
import com.skillstorm.beans.Vehicle;
import com.skillstorm.exceptions.OopsYoureOutOfBoundsException;

public class General {
	//static means that the method/ field is tied to the class, not the instance,
	//non-static methods are tied to the instance/ unique for every instance
	public static String staticName = "Rick";
	public static final String STRINGNAME = "Miles"; //generally you capitalize final variables
	public String nonStaticName = "Joe"; //this is not static, so it cannot be accessed inside a static method

	// starting point for every application
	public static void main(String[] args) throws Exception {
		//this is where every application starts
		//Day1Examples();
		Day2Examples();
	}
	
	//non-static method, so it can access both non-static and static methods/ fields
	public static void method(int value) {
//		String newName = nonStaticName;
//		String newName2 = staticName;
//		
//		//works here
//		Day1Examples();
		System.out.println("Method value: " + value);
	}
	
	//this is a checked exception
	//means that whoever uses this method needs to handle this exception
	public static void Day2Examples() throws Exception {
		//Java is always pass by value, but objects are simialr to pass by reference
		//They pass the value of a reference for objects
		// pass by value = passing a copy of the value
		// pass by reference = passing the memory location
		
		Day2 passByExample = new Day2();
		Animal testDog = new Dog("Dan", "Blue", true, true,"?");
		int testInt = 37;
		
		System.out.println("Start dog: " + testDog.name);
		passByExample.wontChangeValue(testDog);
		System.out.println("End dog: " + testDog.name);
		
		System.out.println("Start dog: " + testDog.name);
		passByExample.willChangeValue(testDog);
		System.out.println("End dog: " + testDog.name);
		
		System.out.println("Start int: " + testInt);
		testInt = passByExample.changeValue(testInt);
		System.out.println("End int: " + testInt);
		
		//arrays
		//very basic collection
		int[] myArray = new int[3]; //cannot change the amount of space later
		//indexing for everything starts at 0, not 1
		myArray[0] = 5;
		myArray[1] = 4;
		myArray[2] = 3;
		
		System.out.println("\nmyArray: ");
		System.out.println(myArray[0]);
		System.out.println(myArray[1]);
		System.out.println(myArray[2]);
		
		int[] myArray2 = { 2, 3, 4 };
		
		System.out.println("myArray2: ");
		System.out.println(myArray2[0]);
		System.out.println(myArray2[1]);
		System.out.println(myArray2[2]);
		
		//this is a reference, so these both look at the same memory location
		int[] arrayCopy = myArray; //not the best way to copy an array
		
		arrayCopy[1] = 75;
		
		System.out.println("arrayCopy: ");
		System.out.println(arrayCopy[0]);
		System.out.println(arrayCopy[1]);
		System.out.println(arrayCopy[2]);

		System.out.println("myArray: ");
		System.out.println(myArray[0]);
		System.out.println(myArray[1]);
		System.out.println(myArray[2]);
		
		//while loop
		int[] newCopyArray = new int[myArray.length];
		int i = 0;
		
		System.out.println("While loop");
		System.out.println("newCopyArray: ");
		while(i < myArray.length) {
			newCopyArray[i] = myArray[i];
			System.out.println(newCopyArray[i]);
			i = i + 1;
		}
		
		newCopyArray[2] = 98;
		//change the value and re-print the array
		i = 0;
		while(i < myArray.length) {
			System.out.println(newCopyArray[i]);
			i = i + 1;
		}
		
		i = 0;
		System.out.println("myArray: ");
		while(i < myArray.length) {
			System.out.println(myArray[i]);
			i = i + 1;
		}
		
		arrayCopy = myArray2.clone();
		
		arrayCopy[2] = 23;
		i = 0;
		System.out.println("arrayCopy: ");
		while(i < arrayCopy.length) {
			System.out.println(arrayCopy[i]);
			i+=1; //incrementor, same as i = i + 1
		}
		/*
		 * i++ : i = i + 1 -> checks the value of i, then increments by 1
		 * i-- : i = i - 1 -> checks the value of i, then decrements by 1
		 * ++i : i = i + 1 -> increments i by 1, then checks the value
		 * --i : i = i - 1 -> decrements i by 1, then checks the value
		 * 
		 * these do the operation before passing the value along
		 * i += x (x is a variable) : i = i + x
		 * i -= x (x is a variable) : i = i - x
		 * i *= x (x is a variable) : i = i * x
		 * i /= x (x is a variable) : i = i / x
		 * i %= x (x is a variable) : i = i % x
		 */
		
		//this checks the conditions and then does the operations
		i = 0;
		System.out.println("myArray2: ");
		while(i < myArray2.length) {
			System.out.println(myArray2[i]);
			i+=1;
		}
		
		System.out.println("------------------");
		System.out.println("original i: " + i);
		//method(i+=1); //work how you'd expect
		//method(++i);
		method(i++);
		System.out.println("after i: " + i);
		
		//do- while loop does the operation and then checks the conditions
		System.out.println("do while loop");
		i = 0;
		do {
			System.out.println(myArray2[i]);
			i++;
		} while (i < myArray2.length);
		
		//bascially a shorthand for a while loop
		//works better with more strict conditions, whereas while
		//loops work with slightly looser conditions
		System.out.println("for loop");
		for(int j = 0; j < myArray2.length; j++) {
			System.out.println(myArray2[j]);
		}
		
		//j is local to the loop, so it does not exist outside of the loop
		System.out.println("for loop 2");
		for(int j = 0; j < myArray2.length; ++j) {
			System.out.println(myArray2[j]);
		}
		
		try {
			//the code you want to work
			System.out.println("for loop 3");
			for(int j = 0; j < myArray2.length;) {
				System.out.println(myArray2[++j]);
			}
			
			//throw new InvalidObjectException("What is it though?");
			//can throw custom exceptions as well
			throw new OopsYoureOutOfBoundsException("Your other left....");
			
			//System.out.println("code executed properly");
		} catch (ArrayIndexOutOfBoundsException ex) {
			//maybe i would put logging inside of here
			System.out.println("Caught the exception");
			
			//ex.printStackTrace();
		} catch (IllegalArgumentException ex) { //still have to be specific
			//if it doesnt work, go here
			//can't just type anything though
			System.out.println("Illegal Arguments caught");
			
		} finally {
			//will always run
			System.out.println("we did it !!!!!!!");
			
		}
//		catch (Exception ex) {
//			//the more general exceptions need to go last, or else they make 
//			//unreachable code
//			System.out.println("in some other exception");
//		}
		
		System.out.println("foreach loop");
		for(int x : myArray) {
			System.out.println(x);
		}
		
		Dog[] dogArray = { new Dog(), new Dog(), new Dog() };
		for(Dog x : dogArray) {
			x.color = "blue";
		}
		
		for(Dog x : dogArray) {
			System.out.println(x.color);
		}
		
		//System.out.println("we did it");
	}
	
	//static so that it can be referenced in main
	public static void Day1Examples() {
		// important keyboard shortcuts
		// ctrl + space will auto-complete/ access intellisense
		// sysout then ctrl + space will expand to System.out.println for you
		//System.out.print("Hello World"); //no new line character
		// after highlighting, ctrl + shift + c comments everything you have highlighted
		System.out.println("Day 1 Examples");
		
		//primitives
		int myInt = 1; //whole numbers only
		
		//generally double is used over float
		double myDouble = 2.0, myDouble2 = 2.0d;
		float myFloat = 3.0f; //need the "f" character to define this value as a float
		
		System.out.println(myInt);
		System.out.println(myDouble);
		System.out.println(myDouble2);
		System.out.println(myFloat);
		
		//Java is smart enough to cast float to double for addition
		double total = myDouble + myFloat;
		
		System.out.println("Total: " + total);
		
		//can also explicitly cast
		double total2 = myDouble + (double)myFloat + myDouble2;
		System.out.println("Total 2: " + total2);
		
		boolean myBool = true; //can only store true or false, cannot be converted to a number like in some other languages
		char myChar = 'A'; //single quotes for a char and double for a string. can be converted to an integer
		
		System.out.println(myBool);
		System.out.println(myChar);
		System.out.print(myChar + 1);
		
		char myChar2 = (char)(myChar + 1);
		System.out.println(" = " + myChar2);
		
		// this is an object
		String myString = staticName;
		
		System.out.println(staticName);
		staticName = "Susan";
		System.out.println(staticName);
		
		System.out.println(STRINGNAME);
		//STRINGNAME = "Susan"; //final variables cannot be changed/ reassigned
		
		System.out.println("--------------------");
		
		//classes
		
		//no import needed for Day1 because they are in the same package
		//Day1 myDay1 = new Day1(); //this uses the default constructor
		Day1 myDay1 = new Day1(4, "Dan Pickles");
		
		System.out.println("Name: " + myDay1.getName() + ", Id: " + myDay1.getId());
		myDay1.setName("Dan Pickles the 2nd");
		myDay1.setId(1);
		myDay1.setEmployed(true);
		System.out.println("Name: " + myDay1.getName() + ", Id: " + myDay1.getId());
		
		System.out.println(myDay1.sayHello());
		
		//myDay1.Day1(); //BAD Practice
		
		//public fields can be directly accessed
		//protected can be accessed here because they are in the same Package
		//default is also accessible here because it is the same package
		//private is only accessible inside the class
//		myDay1.name = "Bobby";
//		myDay1.id = 3;
		
		//covariance
		List<String> myList = myDay1.covariantReturn();
		
		Animal dog = new Dog("Steve", "Black", true, true, "Husky");
		Animal cat = new Cat("Ron", "Orange", true, true, "Green");
		// cannot create an instance of an abstract class
		//Animal rhino = new Animal("Carl", "Grey", true, true);
		
		//dog.name = "Steve";
		//dog.setTail(true);
		
		System.out.println(dog.name);
		System.out.println(dog.isTail());
		
//		cat.name = "Ron";
//		cat.setTail(true);
		
		System.out.println(cat.name);
		System.out.println(cat.isTail());
		
		System.out.println(dog.view());
		//System.out.println(rhino.view());
		System.out.println(cat.view());
		
		//can't access Dog specific values of dog variable inside of Animal
		Dog sameDog = (Dog)dog;
		System.out.println(sameDog.getBreed());
		
		//cannot do this
		//Dog someCat = (Dog)cat;
		
		//just like abstract classes, you cannot create an instance of an interface
		Vehicle cadillac = new Sedan("1955", "Cadillac", "Fleetwood");
		Sedan honda = new Sedan("2010", "Honda", "Civic");
		
		List<Vehicle> dealership = new ArrayList<Vehicle>();
		dealership.add(new Sedan());
		dealership.add(new Truck());
		dealership.add(new Sedan());
		dealership.add(new Truck());
		dealership.add(new Sedan());
		
		for (Vehicle vehicle : dealership) {
			vehicle.displayMileage();
		}
		
		System.out.println(cadillac.getInfo() + "\n" + honda.getInfo());
	}
}
