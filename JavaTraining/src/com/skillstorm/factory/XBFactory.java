package com.skillstorm.factory;

public class XBFactory extends RemoteFactory {

	@Override
	public Remote getRemote() {
		return new XBRemote("Microsoft", new XBWire(), new XBBatteries());
	}

}
