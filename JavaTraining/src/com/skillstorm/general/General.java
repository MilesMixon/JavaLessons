package com.skillstorm.general;
// single line comment
/*
  multi line comment
  this can span multiple lines
  
  anything in a comment is ignored by your compiler
 */

import java.util.List;

import com.skillstorm.beans.Animal;
import com.skillstorm.beans.Cat;
import com.skillstorm.beans.Dog;

public class General {
	//static means that the method/ field is tied to the class, not the instance,
	//non-static methods are tied to the instance/ unique for every instance
	public static String staticName = "Rick";
	public static final String STRINGNAME = "Miles"; //generally you capitalize final variables
	public String nonStaticName = "Joe"; //this is not static, so it cannot be accessed inside a static method

	// starting point for every application
	public static void main(String[] args) {
		//this is where every application starts
		Day1Examples();
	}
	
	//non-static method, so it can access both non-static and static methods/ fields
	public void method() {
		String newName = nonStaticName;
		String newName2 = staticName;
		
		//works here
		Day1Examples();
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
		Animal rhino = new Animal("Carl", "Grey", true, true);
		
		//dog.name = "Steve";
		//dog.setTail(true);
		
		System.out.println(dog.name);
		System.out.println(dog.isTail());
		
//		cat.name = "Ron";
//		cat.setTail(true);
		
		System.out.println(cat.name);
		System.out.println(cat.isTail());
		
		System.out.println(dog.view());
		System.out.println(rhino.view());
		System.out.println(cat.view());
	}
}
