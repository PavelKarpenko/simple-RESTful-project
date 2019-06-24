package com.pavel.simplerestfulproject.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesManager {

	public TablesManager() {

	}

	public void createUsersTable() throws SQLException {

		String createUsersTableQuery = "CREATE TABLE IF NOT EXISTS jdbcdb.USERS(USER_ID BIGINT\t NOT NULL AUTO_INCREMENT, USER_NAME VARCHAR(50) NOT NULL, USER_PASSWORD VARCHAR(50) NOT NULL, PRIMARY KEY (USER_ID))";
		Statement statement = null;
		Connection connection = null;

		try {
			connection = MySqlUtils.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(createUsersTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}
	}

	public void dropUsersTable() throws SQLException {
		String dropUsersTableQuery = "DROP TABLE IF EXISTS jdbcdb.USERS";

		Statement statement = null;
		Connection connection = null;

		try {
			connection = MySqlUtils.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(dropUsersTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
		}
	}
}
