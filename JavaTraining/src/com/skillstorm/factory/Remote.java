package com.skillstorm.factory;

public abstract class Remote {
	private String remoteType;
	private String company;
	private Wire wire;
	private Batteries batteries;
	
	public Remote(String remoteType, String company, Wire wire, Batteries batteries) {
		super();
		this.remoteType = remoteType;
		this.company = company;
		this.wire = wire;
		this.batteries = batteries;
	}

	public String getRemoteType() {
		return remoteType;
	}
	
	public void setRemoteType(String remoteType) {
		this.remoteType = remoteType;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Wire getWire() {
		return wire;
	}
	
	public void setWire(Wire wire) {
		this.wire = wire;
	}
	
	public Batteries getBatteries() {
		return batteries;
	}
	
	public void setBatteries(Batteries batteries) {
		this.batteries = batteries;
	}
	
	public String wireInfo() {
		return "I have a " + company + " wire";
	}
	
	public String batteryInfo() {
		return "I have a " + company + " battery";
	}
	
	public abstract String plugInRemote(int time);
	
	//anything else a remote does
}
