package com.pavel.simplerestfulproject.database;

import com.pavel.simplerestfulproject.dataobject.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCRUD {
	public UserCRUD() {
	}

	public void createUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertUserQuery = "INSERT INTO jdbcdb.USERS(USER_NAME, USER_PASSWORD) VALUES(?, ?)";

		try {
			connection = MySqlUtils.getConnection();
			preparedStatement = connection.prepareStatement(insertUserQuery);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

	public User readUserById(long userId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectUserQuery = "SELECT * FROM jdbcdb.USERS WHERE USER_ID = ?";

		try {
			connection = MySqlUtils.getConnection();
			preparedStatement = connection.prepareStatement(selectUserQuery);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getLong("USER_ID"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setUserPassword(resultSet.getString("USER_PASSWORD"));

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
		preparedStatement.close();
		connection.close();

		return null;
	}

	public ArrayList<User> readAllUsers() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String selectUserQuery = "SELECT * FROM jdbcdb.USERS";

		try {
			connection = MySqlUtils.getConnection();
			preparedStatement = connection.prepareStatement(selectUserQuery);
			resultSet = preparedStatement.executeQuery();

			ArrayList<User> usersArrayList = new ArrayList<>();

			while (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getLong("USER_ID"));
				user.setUserName(resultSet.getString("USER_NAME"));
				user.setUserPassword(resultSet.getString("USER_PASSWORD"));
				usersArrayList.add(user);
			}

			return usersArrayList;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}

		return null;
	}

	public void updateUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateUserQuery = "UPDATE jdbcdb.USERS SET USER_NAME = ?, USER_PASSWORD = ? WHERE USER_ID = ?";

		try {
			connection = MySqlUtils.getConnection();
			preparedStatement = connection.prepareStatement(updateUserQuery);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserPassword());
			preparedStatement.setLong(3, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

	public void deleteUserById(long userId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String deleteUserQuery = "DELETE FROM jdbcdb.USERS WHERE USER_ID = ?";

		try {
			connection = MySqlUtils.getConnection();
			preparedStatement = connection.prepareStatement(deleteUserQuery);
			preparedStatement.setLong(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
