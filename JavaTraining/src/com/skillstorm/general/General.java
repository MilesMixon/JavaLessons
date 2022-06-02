package com.skillstorm.general;
// single line comment
/*
  multi line comment
  this can span multiple lines
  
  anything in a comment is ignored by your compiler
 */

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.skillstorm.beans.Animal;
import com.skillstorm.beans.Cat;
import com.skillstorm.beans.Day2;
import com.skillstorm.beans.Day3;
import com.skillstorm.beans.Dog;
import com.skillstorm.beans.MyFileReader;
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
		//Day2Examples();
		Day3Examples();
	}
	
	public static void Day3Examples() {
		// stack vs heap
		/*
		 * stack: value types and method calls
		 * 			-reference variables
		 * 
		 * heap: objects and any reference types, instance variables
		 * 			-anything that is referenced by it's memory location
		 */
		// Garbage collection: the process java uses to clean up references/ take back memory you are no longer using
		
		//data structures
		/*
		 * List: Interface
		 * 		-It is generic (it can take in any object type)
				-ArrayList
				-LinkedList
		 * 
		 * 		List interface can only store objects
		 * 
		 * ArrayList: array-like implementation of list
		 * 			-under the hood it uses an array
		 * 			-random access just like an array
		 * 			-starts at 10 memory, but automatically resizes for you
		 * 				-resizes by 50% everytime it needs more memory
		 * 			-stored as a continuous block of memory
		 * 
		 * If you want to store primitieves you have to use an object
		 * So to store that you use a Wrapper object
		 * 
		 * Integer
		 * Boolean
		 * Character
		 * Double
		 * Float
		 */
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(4);
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println(list.size());
		
		//autoboxing
		// Java see's that you have a primitive and can automatically convert it 
		// to the object representation for you
//		Integer _int = 3;
//		int _int2 = 3;
		
		/*
		 * LinkedList: pointer implementation. uses "Nodes" to store your data
		 * 				- not necessarily continuous in memory
		 * 				- stores a pointer to the next element in the list
		 * 				- does not support random access, only linear access
		 * 				- doubly linked list implementation
		 */
		List<Integer> list2 = new LinkedList<>(); //paining
		list2.add(3);
		list2.add(6);
		list2.add(7);
		list2.add(4);
		System.out.println(list2);
		System.out.println(list2.get(2));
		System.out.println(list2.size());
		LinkedList<Integer> _list2 = (LinkedList) list2;
		
		//still a reference type
		System.out.println("--------------");
		System.out.println(list2.get(3));
		System.out.println(_list2.get(3));
		_list2.set(3, 27);
		System.out.println(list2.get(3));
		System.out.println(_list2.get(3));
		
		/*
		 * Maps: Key value pairs, allows duplicated
		 * 			-HashMap
		 * 			-unsorted
		 * 
		 * Trees: Sorted branching data structure
		 * 
		 * Sets: similar to maps, do not allow duplicates
		 */
		Map<String, String> birthdays = new HashMap<>(); //unsorted
		Map<String, String> sBirthdays = new TreeMap<>(); //sorted
		birthdays.put("Dan Pickles", "01/12"); //replaces duplicate keys
		sBirthdays.put("Dan Pickles", "01/12");
		birthdays.put("Miles Mixon", "07/13");
		sBirthdays.put("Miles Mixon", "07/13");
		birthdays.put("Austin Reeves", "06/07");
		sBirthdays.put("Austin Reeves", "06/07");
		birthdays.put("Sean Carter", "07/08");
		sBirthdays.put("Sean Carter", "07/08");
		
		//what you iterate over must implement iterable, so we use the entry set
		System.out.println("Unsorted Map");
		for (Map.Entry<String, String> entry : birthdays.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println(birthdays);
		
		System.out.println("Sorted Map");
		for (Map.Entry<String, String> entry : sBirthdays.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println(sBirthdays);
		
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Dave");
		hashSet.add("Richard");
		hashSet.add("Mike");
		hashSet.add("Greg");
		hashSet.add("Greg");
		System.out.println(hashSet);
		
		for (String name : hashSet) {
			System.out.println(name);
		}
		
		//without the foreach
		//this is what a foreach loop does under the hood
		Iterator<String> hashSetIterator = hashSet.iterator();
		while (hashSetIterator.hasNext()) {
			String temp = hashSetIterator.next(); //starts at null
			System.out.println(temp);
		}
		
		//queues and dequeues, usually use a linkedlist
		//linkedlist has all of the methods for these
		//queue: first in first out (FIFO)
		//dequeue (stack): first in last out (FILO)
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.peek()); //see what is at the head without removing it
		System.out.println(q.poll()); //will pop the head and return the value
		System.out.println(q.poll()); //no indexed access
		System.out.println(q.peek());
		
		//instantiate an inner class
		//must go through the outer class
//		Day3<String>.Node node = new Day3().new Node("");
//		node.sayHello();
		System.out.println("-------------------");
		Day3<Integer> myLL = new Day3<>();
		Day3<String> myLL2 = new Day3<>();
		
		myLL.AddHead(1);
		myLL.AddHead(2);
		myLL.AddHead(3);
		
		myLL2.AddHead("One");
		myLL2.AddHead("Two");
		myLL2.AddHead("Three");
		
		myLL.Print();
		myLL2.Print();
		
		System.out.println("Second element: " + myLL.Get(1));
		System.out.println("Second element: " + myLL2.Get(1));
		System.out.println("");
		
		//File IO (Input/ Output)
		//user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a value: ");
		//have to know what you're reading in ahead of time
		//String input = in.nextLine();
		//System.out.println("You entered: " + input);
		
		//if else, and switch statements manage code flow
		/*
		 * if (boolean) 
		 * else if (boolean)
		 * else
		 * 
		 * can chain else if statements
		 */
		int y = 49;
		Object n = null;
		
		//runs whatever is true first
		/* comparison operators
		 * x > y : x greater than y
		 * x < y : x less than y
		 * x >= y : x greater than or equal to y
		 * x <= y : x less than or equal to y
		 * x == y : x equal to y
		 * x != y : x not equal to y
		 * 
		 * logical operators
		 * these do short circuit
		 * if one side is true/ false it ends there
		 * || :  or
		 * && :  and
		 * 
		 * ! :  not
		 * 
		 * bitwise checks your bits
		 * these do not short circuit, so they will always evaluate both sides of the operation
		 * | : bitwise or 
		 * & : bitwise and
		 */
		if (!(y > 50) || n.equals(3)) {
			System.out.println("it was true");
		} else if (y == 5) {
			
		} else if (y < 10) {
			
		} else {
			//runs if nothing else it true
			System.out.println("it wasnt true");
		}
		
		//can do this, but only the first line under the statement belongs to it
		//these are seperate
		//y = 49
		if (y < 48)
			System.out.println("positive");
			
		if (y > 6 && y < 50)
			System.out.println("greater than 6");
		else
			System.out.println("negative");	
		
		while(y > 46)
			y--;
		
		System.out.println(y);
		
		switch (y) {
			case 47:
				System.out.println("case 1:" + y);
				break; //the switch will execute the other block without this
			case 46:
				System.out.println("case 2:" + y);
				break;
			case 45:
				System.out.println("case 3:" + y);
				break;
			default:
				//will run if nothing else is true
				System.out.println("Default statement");
		}
		
		//break takes you out of the loop you are in/ switch statement
		//continue takes you to the next iteration of the loop/ restarts it
		for (int j = 46; j > 23; j--) {
			if (j == 40) {
				break;
			} else if (j % 2 == 0) {
				continue;
			}
			
			System.out.println(j);
		}
		System.out.println("outside");
		
		//read in a file
		MyFileReader.readFile();
		MyFileReader.writeLines();
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
		//Java is always pass by value, but objects are similar to pass by reference
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
