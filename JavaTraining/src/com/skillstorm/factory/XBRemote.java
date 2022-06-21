package com.skillstorm.factory;

public class XBRemote extends Remote {

	public XBRemote(String company, Wire wire, Batteries batteries) {
		super("Xbox", company, wire, batteries);
	}

	@Override
	public String plugInRemote(int time) {
		return "It took me " + time + " minutes to buy batteries.";
	}

}
