package com.contact.CustomHelperClasses;

import com.contact.entities.Login;
import com.contact.entities.User;


public class UserValidation {
	boolean usernameVerification;
	boolean passwordVerification;
	Login currentUser;
	
	//Empty Constructor
	public UserValidation() {
		super();
	}
	
	//Full Constructor
	public UserValidation(boolean usernameVerification, boolean passwordVerification, Login currentUser) {
		super();
		this.usernameVerification = usernameVerification;
		this.passwordVerification = passwordVerification;
		this.currentUser = currentUser;
	}

	 //Constructor without currentUser
	// public UserValidation(boolean usernameVerification, boolean passwordVerification) {
	// 	super();
	// 	this.usernameVerification = usernameVerification;
	// 	this.passwordVerification = passwordVerification;
	// }
	
	//Getters and Setters
	public boolean isUsernameVerification() {
		return usernameVerification;
	}

	public void setUsernameVerification(boolean usernameVerification) {
		this.usernameVerification = usernameVerification;
	}

	public boolean isPasswordVerification() {
		return passwordVerification;
	}

	public void setPasswordVerification(boolean passwordVerification) {
		this.passwordVerification = passwordVerification;
	}


	public Login getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Login currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
