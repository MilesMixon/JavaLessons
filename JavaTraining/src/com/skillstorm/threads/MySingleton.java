package com.skillstorm.threads;

public class MySingleton {
	//there should only ever be one instance of this
	
	//the only instance that should be created
	private static MySingleton instance = null;
	
	//no one can call this constructor expect for the MySingleton class
	private MySingleton() { }
	
	//not thread safe
	public static MySingleton getInstance() {
		//multiple threads can potentially access this at the same time
		if (instance == null) {
			instance = new MySingleton();
		}
		
		return instance;
	}
}
