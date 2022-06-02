package com.skillstorm.beans;

//every method is abstract in an interface, and dont need to use the abstract keyword
//classes can implement multiple interfaces
//classes can only extend one class
//interfaces have to be public and all methods and fields inside of an interface are public
public interface Vehicle {
	//under the hood every variable i define in an interface
	//is public static final
	int myValue = 5;
	
	//everything that implements Vehicle needs to implement these
	//generally interfaces would just be abstract methods like these three
	public String getInfo();
	public String startEngine();
	public String displayMileage();
	
	//this is optional to implement. Many frameworks use this
	//default implementation, you can only want to have one default honkHorn method
	//implementations
	default void honkHorn() {
		System.out.println("Honk!");
	}
	
	default double pumpGas(double gallons) {
		return gallons * 6.45;
	}
	
	//can also define static methods
	static double drive() {
		return 2.0;
	}
}
