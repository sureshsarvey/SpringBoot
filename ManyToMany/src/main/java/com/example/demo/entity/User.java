package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "many_user")
public class User implements Serializable
{
	
   @Id
   @Column(name = "user_id")
   private String userId;
   
   @Column(name = "user_name")
   private String userName;

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + "]";
}
   
   
   
   
}
