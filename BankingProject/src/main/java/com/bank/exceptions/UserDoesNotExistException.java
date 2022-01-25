package com.bank.exceptions;

public class UserDoesNotExistException extends RuntimeException {
	private static long serialVersionUID = 1L;
	
	public UserDoesNotExistException() {
		super("User tried to log in with non-existing credentials.");
	}
}
