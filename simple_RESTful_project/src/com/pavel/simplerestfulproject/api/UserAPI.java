package com.pavel.simplerestfulproject.api;

import com.pavel.simplerestfulproject.database.TablesManager;
import com.pavel.simplerestfulproject.database.UserCRUD;
import com.pavel.simplerestfulproject.dataobject.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/*
 * before using this class first read the comments
 * in TestCRUD class and make sure everything is working
 * then run this project on tomcat v9.0
 * and copy the url to the postman softwear and add "/user"
 * to the url and start sending requests
 * */
@Path("/user")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class UserAPI {
	private static boolean IS_USERS_TABLE_CREATED = false;

	public UserAPI() throws SQLException {
		if (!IS_USERS_TABLE_CREATED) {
			TablesManager tablesManager = new TablesManager();
			tablesManager.createUsersTable();
			IS_USERS_TABLE_CREATED = true;
		}
	}

	@POST
	public String createUser(User user) throws SQLException {
		UserCRUD userCRUD = new UserCRUD();
		userCRUD.createUser(user);
		return "user " + user.getUserName() + " created!";
	}

	@GET
	@Path("/all")
	public ArrayList<User> getAllUsers() throws SQLException {
		UserCRUD userCRUD = new UserCRUD();
		return userCRUD.readAllUsers();
	}

	@GET
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") long userId) throws SQLException {
		UserCRUD userCRUD = new UserCRUD();
		return userCRUD.readUserById(userId);
	}

	@PUT
	public String updateUser(User user) throws SQLException {
		UserCRUD userCRUD = new UserCRUD();
		userCRUD.updateUser(user);
		return "user " + user.getUserName() + " updated!";
	}

	@DELETE
	@Path("/{userId}")
	public String deleteUser(@PathParam("userId") long userId) throws SQLException {
		UserCRUD userCRUD = new UserCRUD();
		userCRUD.deleteUserById(userId);
		return "user deleted";
	}
}
