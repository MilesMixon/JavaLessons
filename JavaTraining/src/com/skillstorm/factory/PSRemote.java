package com.skillstorm.factory;

public class PSRemote extends Remote {

	public PSRemote(String company, Wire wire, Batteries batteries) {
		super("Playstation", company, wire, batteries);
	}

	@Override
	public String plugInRemote(int time) {
		return "Playstation remote is charging for " + time + " minutes.";
	}

}
