package com.skillstorm.exceptions;

//names for your exceptions always end with Exception
//all exceptions extend Exception
public class OopsYoureOutOfBoundsException extends Exception {

	public OopsYoureOutOfBoundsException() {
		super();
	}
	
	public OopsYoureOutOfBoundsException(String message) {
		super(message);
	}
}
