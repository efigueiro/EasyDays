package com.easydays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseModel {

	/*
	 * jdbc:<alias banco de dados>://<ip>:<porta>/<esquema>
	 */
	private static final String URL = "jdbc:postgresql://localhost:5432/EasyDays";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String PASSWORD = "scorpion";
	private static final String USUARIO = "postgres";

	/*
	 * connection
	 */

	public Connection getConnection() throws Exception {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return connection;
	}
}
