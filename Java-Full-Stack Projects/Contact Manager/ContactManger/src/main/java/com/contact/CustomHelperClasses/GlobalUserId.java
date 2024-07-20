package com.contact.CustomHelperClasses;

public class GlobalUserId {
	private String currentUser_Id;

	
	public GlobalUserId() {
		super();
	}

	public GlobalUserId(String currentUser_Id) {
		super();
		this.currentUser_Id = currentUser_Id;
	}

	public String getCurrentUser_Id() {
		return currentUser_Id;
	}

	public void setCurrentUser_Id(String currentUser_Id) {
		this.currentUser_Id = currentUser_Id;
	}
	
}
