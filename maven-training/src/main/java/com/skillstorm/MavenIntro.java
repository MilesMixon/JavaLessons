package com.skillstorm;

import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Vehicle;

public class MavenIntro {

	public static void main(String[] args) {
		Vehicle car = new Sedan("2019", "Hyundai", "Elantra");
		
		System.out.println(car.getInfo());
	}
}
