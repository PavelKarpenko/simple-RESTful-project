package com.pavel.simplerestfulproject.dataobject;


public class User
{
  private long UserId;
  private String userName;
  private String userPassword;
  
  public User() {}
  
  public User(String userName, String UserPassword)
  {
    this.userName = userName;
    userPassword = UserPassword;
  }
  
  public User(long userId, String userName, String userPassword)
  {
    UserId = userId;
    this.userName = userName;
    this.userPassword = userPassword;
  }
  
  public long getUserId() {
    return UserId;
  }
  
  public void setUserId(long userId) {
    UserId = userId;
  }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getUserPassword() {
    return userPassword;
  }
  
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  
  public String toString()
  {
    return "User [UserId=" + UserId + ", userName=" + userName + ", userPassword=" + userPassword + "] \n";
  }
}
