package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.User;

public interface UserDAO {
	List<User> getAllUsers();

	User getUserbyUsername(String username);

	void createUser(User u) throws SQLException;

	void updateUser(User u);

	void deleteUser(User u);
}
