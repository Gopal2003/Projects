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

	public List<User> getUserDetails() {
		
		List<User> UserDetails = new ArrayList<>();
		
		userrepository.findAll()
		.forEach(UserDetails :: add);
		
		return UserDetails;
	}

	public String updateUserDetails(User user) {
		
		 CurrentUserId currentLogginedUser = CurrentUserId.getInstace();
		 System.out.println("CurrentUSerId In updateUSer : " + currentLogginedUser.getCurrentUserId());
		 System.out.println("User updateing ID: " + user.getId());
		 
		 if(currentLogginedUser.getCurrentUserId() == null)
		 {
			 return "You are not logged-in, Login with your username and password in order to update your details";
		 }
		 else if(!(currentLogginedUser.getCurrentUserId().equals(user.getId())))
		 {
			 return "You are not allowed to chagne the user details of the other users!!";
		 }
		 
		 userrepository.save(user);
		 
		 return "User Updated Successfully";
	}

	public void deleteUserDetails(String id) {
		
		userrepository.deleteById(id);
	}
	
//	public User getUserTest(String id)
//	{
//		return userrepository.findByid(id);
//	}
	
	
	
}
