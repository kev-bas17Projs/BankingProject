package com.bank.models;

import java.util.Random;

public class BankAccount {
	private int accountnum;
	private double balance;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(int accountnum, double balance) {
		super();
		this.accountnum = accountnum + (new Random().nextInt(9000) + 1000);
		this.balance = balance + (new Random().nextInt(9000) + 1000);
	}
	
	// Retrieve from db
	/*public BankAccount(int accountnum, double balance) {
		this.accountnum = accountnum;
		this.balance = balance;
	}*/

	public int getAccountnum() {
		return accountnum;
	}

	public void setAccountnum(int accountnum) {
		this.accountnum = accountnum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountnum=" + accountnum + ", balance=" + balance + "]";
	}
	
	
	
}