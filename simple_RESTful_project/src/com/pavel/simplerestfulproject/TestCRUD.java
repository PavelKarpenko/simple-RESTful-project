package com.pavel.simplerestfulproject;

import com.pavel.simplerestfulproject.database.TablesManager;
import com.pavel.simplerestfulproject.database.UserCRUD;
import com.pavel.simplerestfulproject.dataobject.User;
import java.sql.SQLException;

public class TestCRUD {
	
	public TestCRUD() {
		
	}

	public static void main(String[] args) {
		
		TablesManager tablesManager = new TablesManager();
		UserCRUD userCRUD = new UserCRUD();

		/*
		 * go to mySql community database and create your database.
		 * go to MySqlUtils class and change the database name,user name
		 * and password to yours then come back here and
		 * run first line in try block then go to your database 
		 * to confirm that the table was created, uncomment next line ,run again, 
		 *  check database and so on. notice that you need to
		 *  uncomment some lines all together because they are related.
		 * */
		try {
			tablesManager.createUsersTable();
//			User user = new User("test", "1234");
//			userCRUD.createUser(user);
//			System.out.println(userCRUD.readAllUsers());
//			System.out.println(userCRUD.readUserById(0)); // enter the id you want to get
//			User updatedUser = new User(0, "updated", "updated"); // enter the id you want to update
//			userCRUD.updateUser(updatedUser);
//			userCRUD.deleteUserById(1);
//			tablesManager.dropUsersTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
