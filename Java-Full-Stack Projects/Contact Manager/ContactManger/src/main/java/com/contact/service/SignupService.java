package com.contact.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entities.Login;
import com.contact.entities.User;
import com.contact.repository.LoginRepository;
import com.contact.repository.UserRepository;

@Service
public class SignupService {

	// inject the user repository and login repository
	@Autowired 
	private UserRepository userrepository;
	
	@Autowired
	private LoginRepository loginrepository;
	
	public int addUser(User user) {
		
		//Checking User ID exists or not in database. This is a simple example and in a real world scenario, you need to implement a more robust ID checking mechanism.
		Integer currentId = user.getId();
		User isExist = userrepository.findByid(currentId);
		
		//Checking Email Id
		String currentUserEmail =user.getEmail();
		User emailExist = userrepository.findByemail(currentUserEmail);	
		
		//Checking Username exists or not in database. 
		String currentUsername = user.getUsername();
		User usernameExist = userrepository.findByusername(currentUsername);
		
		// If any user exists return respective error code else save the user and login details.
		 if(isExist != null)
		{
			return 2;
		}
		 else if(usernameExist != null)
		{
			return 3;
		}
		else if(emailExist != null)
		{
			return 1;
		}

		// If no user exists then save the user and login details.
		userrepository.save(user);

		// Also save the login details.
		Login loginDetails = new Login(user.getUsername(),user.getPassword(),user.getId());
		
		// print the saved user and login details.
		System.out.println(loginDetails.getUsername() + " " + loginDetails.getPassword() + " " + loginDetails.getUser_id());
	
		// Save the login details.
		loginrepository.save(loginDetails);
		
		return 0;
	}

}
