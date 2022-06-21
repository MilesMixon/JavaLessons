package com.skillstorm.factory;

public class PSFactory extends RemoteFactory {

	@Override
	public Remote getRemote() {
		return new PSRemote("Sony", new PSWire(), new PSBatteries());
	}

}
