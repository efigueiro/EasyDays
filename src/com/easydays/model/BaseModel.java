package com.easydays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.easydays.util.DataBaseCredential;

public abstract class BaseModel {

	/*
	 * connection
	 */

	public Connection getConnection() throws Exception {
		try {
			Class.forName(DataBaseCredential.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					DataBaseCredential.getProperty("url"), 
					DataBaseCredential.getProperty("user"),
					DataBaseCredential.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return connection;
	}
}
