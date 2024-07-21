package com.contact.CustomHelperClasses;


//Singleton class.
public class GlobalUserId {
	
	private String currentUserId;
	
	private GlobalUserId() {
		
		
	}
	
	private static GlobalUserId instance;
	
	
	public static GlobalUserId getInstace()
	{
		if(instance == null)
		{
			instance =  new GlobalUserId();
		}
		
		return instance;
	}
	
	public String getCurrentUserId() {
		return currentUserId;
	}


	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	
//	private String currentUser_Id;
//
//	
//	public GlobalUserId() {
//		super();
//	}
//
//	public GlobalUserId(String currentUser_Id) {
//		super();
//		this.currentUser_Id = currentUser_Id;
//	}
//
//	public String getCurrentUser_Id() {
//		return currentUser_Id;
//	}
//
//	public void setCurrentUser_Id(String currentUser_Id) {
//		this.currentUser_Id = currentUser_Id;
//	}
	
}
