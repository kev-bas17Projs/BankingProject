package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.utils.ConnectionUtil;
import com.bank.models.User;

public abstract class DBUserDAO implements UserDAO {

	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();

		try {
			Connection conn = conUtil.getConnection();
			String sql = "select * from users";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				userList.add(
						new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}

			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public User getUserByUsername(String username) {
		User user = new User();

		try {
			Connection conn = conUtil.getConnection();

			String sql = "select * from users where users.username = ' " + username + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				user.setFirstname(rs.getString(1));
				user.setLastname(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createUser(User u) throws SQLException {
		Connection conn = conUtil.getConnection();
		String sql = "insert into users(first_name, last_name, username, password) values " + "(?, ?, ?, ?)";

		PreparedStatement PrepStmt = conn.prepareStatement(sql);

		PrepStmt.setString(1, u.getFirstname());
		PrepStmt.setString(2, u.getLastname());
		PrepStmt.setString(3, u.getUsername());
		PrepStmt.setString(4, u.getPassword());

		PrepStmt.execute();
	}

	public void updateUser(User u) {
		try {
			Connection conn = conUtil.getConnection();
			String sql = "update users set first_name = ?, last_name = ?, username = ?, password = ? "
					+ " where users.username = ?";
			PreparedStatement PrepStmt = conn.prepareStatement(sql);

			PrepStmt.setString(1, u.getFirstname());
			PrepStmt.setString(2, u.getLastname());
			PrepStmt.setString(3, u.getUsername());
			PrepStmt.setString(4, u.getPassword());

			PrepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(User u) {

		try {
			Connection conn = conUtil.getConnection();
			String sql = "delete from users users.username = ?";
			PreparedStatement PrepStmt = conn.prepareStatement(sql);

			PrepStmt.setString(3, u.getUsername());

			PrepStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
