package com.contact.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	private String id;
	
	private String name;
	@Column(name="email")
	private String Email;
	@Column(name="password")
	private String Password;
	
	
	public User() {
		super();
	}
	public User(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		Password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
