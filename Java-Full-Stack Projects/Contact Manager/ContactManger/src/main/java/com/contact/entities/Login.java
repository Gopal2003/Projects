package com.contact.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String username;
	private String password;
	
	private String user_id;
	
	public Login() {
		super();
	}
	
	
	public Login(String username, String password, String user_id) {
		super();
		this.username = username;
		this.password = password;
		this.user_id = user_id;
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
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", user_id=" + user_id + "]";
	}
	
	
	
}
