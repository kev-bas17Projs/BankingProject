package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.BankAccount;

public interface BankAccountDAO {

	List<BankAccount> getAllAcounts();

	BankAccount getAccountByAccountNum(int accountnum);

	void createAccountNum(BankAccount accnum) throws SQLException;

	void updateAccountNum(BankAccount accnum);

	void deleteAccountNum(BankAccount accnum);

}
