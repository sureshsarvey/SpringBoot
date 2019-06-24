package com.boot.database.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Test_User")
public class User implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7349656574795180114L;

	@Id
	 @Column(name = "user_id")
     private String userId;
	 
	 @Column
	 private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
     
}
