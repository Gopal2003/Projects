package com.contact.CustomHelperClasses;


//Singleton class.
public class CurrentUserId {
	
	private Integer currentUserId;
	
	private CurrentUserId() {
		
		
	}
	
	private static CurrentUserId instance;
	
	
	public static CurrentUserId getInstace()
	{
		if(instance == null)
		{
			instance =  new CurrentUserId();
		}
		
		return instance;
	}
	
	public Integer getCurrentUserId() {
		return currentUserId;
	}


	public void setCurrentUserId(Integer currentUserId) {
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
