package com.bank.services;

import com.bank.logging.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.BankAccount;
import com.bank.dao.BankAccountDAO;

import com.bank.models.User;
import com.bank.dao.UserDAO;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankServices {
	private BankAccountDAO BankAccDAO;

	public BankServices(BankAccountDAO bankacc) {
		this.BankAccDAO = bankacc;
	}
	
	
}
