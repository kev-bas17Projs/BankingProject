package com.bank.exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("User tried to log in with non existing credentials.");
	}
}
