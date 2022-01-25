package com.bank.models;

public class Customer extends User {

	public Customer() {
		super.setCustomerAccess(true);
		super.setEmployeeAccess(false);
	}
	
	public Customer(int accountnum, String firstname, String lastname, String username, String password) {
		super(accountnum, firstname, lastname, username, password);
	}
	
}
