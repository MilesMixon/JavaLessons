package com.skillstorm.beans;

//Generics
public class Day3<T> {
	//Generics only work with objects in java, not primitives. primitives would need wrappers
	//these do work with autoboxing
	//generics can be denotes by:
	// E - elements
	// K - keys
	// N - numbers
	// T - type
	// V - value
	
	//this is a linked list for all intents and purposes
	//because objects are reference types, this works
	//this is a pointer to the first element
	private Node head;
	
	public Day3() {
		head = null;
	}
	
	public void AddHead(T t) {
		Node n = new Node(t);
		n.next = head;
		head = n;
	}
	
	public void Print() {
		Node current = head;
		
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public T Get(int index) {
		int count = 0;
		Node current = head;
		
		while (count < index) {
			current = current.next;
			count++;
		}
		
		return current.data;
	}
	
	//inner class
	//dont need getters and setters because the only thing that can access this is
	//through Day3, the outer class
	//Day 3 owns this class, it's the same as any other instance variable you would define
	private class Node {
		
		private Node next;
		private T data;
		
		private Node(T t) {
			next = null;
			data = t;
		}
		
//		public void sayHello() {
//			System.out.println("Hello World");
//		}
	}
}
