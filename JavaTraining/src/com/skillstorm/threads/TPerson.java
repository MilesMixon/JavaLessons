package com.skillstorm.threads;

public class TPerson {
	private BankAccount account;
	private String name;
	
	public TPerson(String name, BankAccount account) {
		super();
		this.account = account;
		this.name = name;
	}

	public void add(double amt) {
		double newBalance = account.addMoney(amt);
		System.out.println(name + " deposited " + amt + ", the new balance is " + newBalance);
	}
	
	public void withdraw(double amt) {
		double newBalance = account.withdrawMoney(amt);
		System.out.println(name + " withdrew " + amt + ", the new balance is " + newBalance);
	}
}
