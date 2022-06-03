package com.skillstorm.threads;

public class ProducerConsumer {
	//hypothetically this is a supermarket
	private static Object mutex = new Object();
	private int produce = 0;
	
	public ProducerConsumer() { }
	
	public void addProduce(int amt) {
		synchronized (mutex) {
			System.out.println("Producer " + Thread.currentThread() + " is adding " + amt + " produce");
			produce += amt;
			System.out.println("Producer " + Thread.currentThread() + " is finished");
			
			//wakes up all threads that are waiting on the mutex
			mutex.notifyAll();
		}
	}
	
	public void consumeProduce(int amt) {
		synchronized (mutex) {
			System.out.println("Consumer " + Thread.currentThread() + " wants to consume " + amt);
			
			while (produce < amt) {
				System.out.println("Consumer " + Thread.currentThread() + " waits");
				
				try {
					mutex.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.out.println("Consumer " + Thread.currentThread() + " checks again");
			}
			
			System.out.println("Consumer " + Thread.currentThread() + " consumes " + amt);
			produce -= amt;
		}
	}
}
