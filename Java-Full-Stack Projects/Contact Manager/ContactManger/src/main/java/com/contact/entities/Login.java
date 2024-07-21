package com.contact.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {
	
	@Id
	private String username;
	private String password;
	
	private String userid;
	
	public Login() {
		super();
	}
	
	
	public Login(String username, String password, String userid) {
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
	
	public String getUser_id() {
		return userid;
	}
	public void setUser_id(String user_id) {
		this.userid = user_id;
	}
	
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", userid=" + userid + "]";
	}
	
	
	
}
