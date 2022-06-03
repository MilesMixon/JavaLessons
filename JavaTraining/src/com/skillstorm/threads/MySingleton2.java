package com.skillstorm.threads;

public class MySingleton2 {
	//there should only ever be one instance of this
	
	//the only instance that should be created
	private static MySingleton2 instance = null;
	private static Object mutex = new Object(); //monitor: used to lock and object
	//the type is not important as long as all of the threads can access it and only 
	//one accesses it at a time
	
	//no one can call this constructor expect for the MySingleton class
	private MySingleton2() { }
	
	//thread safe
	public static MySingleton2 getInstance() {
		//multiple threads can potentially access this at the same time
		//critical section
		//any section only one thread at a time should access
		//only want to lock on parts of code that change a value
		
		//synchronized block:
		/*
		 * a thread tried to get a hold of mutex
		 * whichever thread gets the mutex locks it and proceeds
		 * the others have to wait
		 * will also release the lock for you if the thread with the lock errors out
		 */
		synchronized (mutex) {
			if (instance == null) {
				instance = new MySingleton2();
			}
		}
		
		return instance;
	}
}
