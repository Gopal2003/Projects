package com.contact.CustomHelperClasses;


//Singleton class.
public class CurrentUserId {
	
	//The singleton instance.
	private Integer currentUserId;
	
	//private constructor to avoid instantiation from outside.  This is a Singleton.
	private CurrentUserId() {
		
		
	}
	//static initialization block. This is thread-safe because this block is executed only once when the class
	private static CurrentUserId instance;
	
	//static method to create and return the single instance of this class.
	public static CurrentUserId getInstace()
	{
		if(instance == null)
		{
			instance =  new CurrentUserId();
		}
		
		return instance;
	}
	
	//Getter and setter methods.  They allow other classes to read and write the currentUserId. 
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
