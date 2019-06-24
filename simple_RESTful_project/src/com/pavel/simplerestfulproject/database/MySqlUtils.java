package com.pavel.simplerestfulproject.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtils {
	private static final String MYSQL_DATABASE_NAME = "jdbcdb";
	private static final String MYSQL_USER_NAME = "root";
	private static final String MYSQL_PASSWORD = "pavel";
	private static final String JDBC_CONNECTION_URL = "jdbc:mysql://localhost:3306/" + MYSQL_DATABASE_NAME;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private MySqlUtils() {
	}

	public static Connection getConnection() throws SQLException {
		java.sql.Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL, MYSQL_USER_NAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
