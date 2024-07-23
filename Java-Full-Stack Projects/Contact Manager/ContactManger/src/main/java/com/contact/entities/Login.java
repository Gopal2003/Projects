package com.contact.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//This is the User entity, which represents each user in the system
@Entity
public class Login {
	
	//Primary key is the username as username is unique in the system.
	@Id
	private String username;
	private String password;
	
	private Integer userid;
	
	public Login() {
		super();
	}
	
	
	public Login(String username, String password, Integer userid) {
		super();
		this.username = username;
		this.password = password;
		this.userid = userid;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getUser_id() {
		return userid;
	}
	public void setUser_id(Integer user_id) {
		this.userid = user_id;
	}
	
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", userid=" + userid + "]";
	}
	
	
	
}
