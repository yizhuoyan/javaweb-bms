package com.valentinalee.bms.exception;

public class ThisAppException extends RuntimeException {

	public ThisAppException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ThisAppException(String message) {
		super(message);
		
	}

	public ThisAppException(Throwable cause) {
		super(cause);
		
	}

	
}
