package com.bank.models;

import java.util.Random;

public class User {
	private int accountnum;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private boolean access;
	//private int balance;
	
	public User() {
		super();
	}
	
	public User(int accountnum, String firstname, String lastname, String username, String password, boolean access) {
		super();
		this.accountnum = accountnum + (new Random().nextInt(9000) + 1000);
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = firstname + lastname;
		this.password = password + (new Random().nextInt(9000) + 1000);
		this.access = access;
	}
	
	// Get user info from db
	public User(int accountnum, String firstname, String lastname, String username, String password) {
		this.accountnum = accountnum;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public int getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getAccess() {
		return access;
	}
	
	public void setCustomerAccess(boolean CustomerAccess) {
		CustomerAccess = this.access;
	}
	
	public void setEmployeeAccess(boolean EmployeeAccess) {
		EmployeeAccess = this.access;
	}

	@Override
	public String toString() {
		return "User [accountnum=" + accountnum + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
}
