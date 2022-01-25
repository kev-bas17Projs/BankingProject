package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.utils.ConnectionUtil;
import com.bank.models.BankAccount;

public class DBBankAccountDAO implements BankAccountDAO {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	public List<BankAccount> getAllAcounts() {
		List<BankAccount> AccountList = new ArrayList<BankAccount>();

		try {
			Connection conn = conUtil.getConnection();
			String sql = "select * from bankaccount";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				AccountList.add(new BankAccount(rs.getInt(1), rs.getInt(2)));
			}
			return AccountList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BankAccount getAccountByAccountNum(int accountnum) {
		BankAccount bankacc = new BankAccount();

		try {
			Connection conn = conUtil.getConnection();
			String sql = "select * from bankaccount where bankaccount.account_num = ' " + accountnum + " '";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				bankacc.setAccountnum(rs.getInt(1));
				bankacc.setBalance(rs.getInt(2));
			}
			return bankacc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createAccountNum(BankAccount accnum) throws SQLException {
		Connection conn = conUtil.getConnection();
		String sql = "insert into bankaccount(account_num, balance) values" + "(?,?)";
		PreparedStatement PrepStmt = conn.prepareStatement(sql);

		PrepStmt.setInt(1, accnum.getAccountnum());
		PrepStmt.setInt(2, (int) accnum.getBalance());

		PrepStmt.execute();
	}

	public void updateAccountNum(BankAccount accnum) {
		try {
			Connection conn = conUtil.getConnection();
			String sql = "update bankaccount set account_num = ?, balance = ? " + " where bankaccount.account_num = ?";
			PreparedStatement PrepStmt = conn.prepareStatement(sql);

			PrepStmt.setInt(1, accnum.getAccountnum());
			PrepStmt.setInt(2, (int) accnum.getBalance());

			PrepStmt.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteAccountNum(BankAccount accnum) {
		try {
			Connection conn = conUtil.getConnection();
			String sql = "delete from bankaccount bankaccount.account_num = ?";
			PreparedStatement PrepStmt = conn.prepareStatement(sql);

			PrepStmt.setInt(1, accnum.getAccountnum());
			PrepStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
