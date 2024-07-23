package com.contact.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entities.Login;
import com.contact.entities.User;
import com.contact.repository.LoginRepository;
import com.contact.repository.UserRepository;

@Service
public class SignupService {

	@Autowired 
	private UserRepository userrepository;
	
	@Autowired
	private LoginRepository loginrepository;
	
	public int addUser(User user) {
		
		Integer currentId = user.getId();
		User isExist = userrepository.findByid(currentId);
		
		//Checking Email Id
		String currentUserEmail =user.getEmail();
		User emailExist = userrepository.findByemail(currentUserEmail);	
		
		String currentUsername = user.getUsername();
		User usernameExist = userrepository.findByusername(currentUsername);
		
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

		userrepository.save(user);
		
		Login loginDetails = new Login(user.getUsername(),user.getPassword(),user.getId());
		
		System.out.println(loginDetails.getUsername() + " " + loginDetails.getPassword() + " " + loginDetails.getUser_id());
	
		loginrepository.save(loginDetails);
		
		return 0;
	}

}
