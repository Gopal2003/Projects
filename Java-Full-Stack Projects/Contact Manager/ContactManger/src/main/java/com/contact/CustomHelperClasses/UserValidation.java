package com.contact.CustomHelperClasses;

import com.contact.entities.Login;
import com.contact.entities.User;

public class UserValidation {
	boolean first;
	boolean second;
	Login currentUser;
	
	public UserValidation() {
		super();
	}
	
	public UserValidation(boolean first, boolean second, Login currentUser) {
		super();
		this.first = first;
		this.second = second;
		this.currentUser = currentUser;
	}

	public UserValidation(boolean first, boolean second) {
		super();
		this.first = first;
		this.second = second;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isSecond() {
		return second;
	}
	public void setSecond(boolean second) {
		this.second = second;
	}

	public Login getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Login currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
