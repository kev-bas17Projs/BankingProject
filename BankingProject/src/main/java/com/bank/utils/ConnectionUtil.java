package com.bank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil ConnUtil;
	private static Properties prop = new Properties();

	private ConnectionUtil() {
	}

	public static synchronized ConnectionUtil getConnectionUtil() {
		if (ConnUtil == null) {
			return new ConnectionUtil();
		}
		return ConnUtil;
	}

	public Connection getConnection() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		String url = "";
		String username = "";
		String password = "";

		try {
			prop.load(is);
			url = (String)prop.getProperty("url");
			username = (String)prop.getProperty("username");
			password = (String)prop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
