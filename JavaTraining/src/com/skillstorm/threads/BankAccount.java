package com.skillstorm.threads;

public class BankAccount {
	private static Object mutex = new Object();
	private double balance;
	
	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	//we want to synchonize these
	public double addMoney(double amount) {
		synchronized (mutex) {
			balance += amount;
		}
		return balance;
	}
	
	public double withdrawMoney(double amount) {
		synchronized (mutex) {
			if (amount <= balance) {
				balance -= amount;
			}
		}
		return balance;
	}
}
