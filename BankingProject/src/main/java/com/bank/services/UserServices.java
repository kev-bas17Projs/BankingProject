package com.bank.services;

import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
import com.bank.exceptions.UserNameAlreadyExistsException;
import com.bank.exceptions.UserNotFoundException;

import com.bank.logging.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.User;
import com.bank.dao.UserDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
	private UserDAO uDAO;

	public UserServices(UserDAO u) {
		this.uDAO = u;
	}
	
	public User SignUp(int AccountNum, String firstNm, String lastNm, String userNm, String pw) throws UserNameAlreadyExistsException{
		User u = new User(AccountNum, firstNm, lastNm, userNm, pw);
		try {
			uDAO.createUser(u);
			Logging.logger.info("New user has been registered.");
		}catch(SQLException e) {
			Logging.logger.info(e);
			Logging.logger.info("Username already existed.");
			throw new UserNameAlreadyExistsException();
		}
		return u;
	}
	
	public User LogIn(String userNm, String pw) throws InvalidCredentialsException {
		User u = uDAO.getUserbyUsername(userNm);
		
		if(u.getUsername().equals(null)) {
			Logging.logger.warn("User who logged in does not exist.");
			throw new UserDoesNotExistException();
		}
		
		else if(!u.getPassword().equals(pw)) {
			Logging.logger.warn("User credentials not valid.");
			throw new InvalidCredentialsException();
		} else {
			Logging.logger.info("User has logged in.");
		}
		return u;
	}

}
