package com.contact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.CustomHelperClasses.CurrentUserId;
import com.contact.entities.User;
import com.contact.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;

	// Get all user details
	public List<User> getUserDetails() {
		
		List<User> UserDetails = new ArrayList<>();
		
		userrepository.findAll()
		.forEach(UserDetails :: add);
		
		return UserDetails;
	}
	// Get user details by id
	@SuppressWarnings("unused")
	public String updateUserDetails(User user) {
		
		 // Check if current user is logged-in.
		 CurrentUserId currentLogginedUser = CurrentUserId.getInstace();
		 
		 
		 System.out.println("CurrentUSerId In updateUSer : " + currentLogginedUser.getCurrentUserId());
		 System.out.println("username : " + user.getUsername());
		 
		 // Check if the username is already taken.
		 User userFromDatabase = userrepository.findByusername(user.getUsername());
		 System.out.println("User updateing ID: " + userFromDatabase.getId());
		 
		 // Only logged-in user can modify his/her own details.
		 if(userFromDatabase == null)
		 {
			 return "You Cannot Modify the Username";
		 }
		 else if(currentLogginedUser.getCurrentUserId() == 0)// Check if current user is logged-in.
		 {
			 return "You are not logged-in, Login with your username and password in order to update your details";
		 }
		 else if(!(currentLogginedUser.getCurrentUserId() == userFromDatabase.getId()))// Check if current user is allowed to modify the user details.
		 {
			 return "You are not allowed to chagne the user details of the other users!!";
		 }
		 
		 userrepository.save(user);
		 
		 return "User Updated Successfully";
	}

	// Delete user details by id
	public void deleteUserDetails(Integer id) {
		
		userrepository.deleteById(id);
	}
	
//	public User getUserTest(String id)
//	{
//		return userrepository.findByid(id);
//	}
	
	
	
}
