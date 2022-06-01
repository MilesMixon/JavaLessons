package com.skillstorm.beans;

//a Cat is an Animal
public class Cat extends Animal {

	private String eyeColor;
	
	public Cat(String name, String color, boolean tail, boolean fur, String eyeColor) {
		super(name, color, tail, fur);
		this.eyeColor = eyeColor;
	}
	
	public String getEyeColor() {
		return eyeColor;
	}
	
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	@Override
	public String view() {
		return super.view() + ". But a cat, so evil.";
	}

	@Override
	public void move(int distance) {
		System.out.println("Walked " + distance/2);
	}

	@Override
	public String speak() {
		return "Meow";
	}
}
