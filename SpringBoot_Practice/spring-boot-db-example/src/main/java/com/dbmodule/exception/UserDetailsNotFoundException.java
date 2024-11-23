package com.dbmodule.exception;

@SuppressWarnings("serial")
//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDetailsNotFoundException extends RuntimeException {
	
	public UserDetailsNotFoundException(String message) {
		super(message);
	}
}
