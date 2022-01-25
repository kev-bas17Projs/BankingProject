package com.bank.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
private static final long serialVersionUID = 1L;

public UserNameAlreadyExistsException() {
	super("Username already exists in database.");
}
}
