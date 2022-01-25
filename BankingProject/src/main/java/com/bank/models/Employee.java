package com.bank.models;

public class Employee extends User {
	
	public Employee() {
		super.setCustomerAccess(false);
		super.setEmployeeAccess(true);
	}
	
	public Employee(int accountnum, String firstname, String lastname, String username, String password) {
		super(accountnum, firstname, lastname, username, password);
	}
}
