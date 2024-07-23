package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.CustomHelperClasses.UserValidation;
import com.contact.entities.Login;
import com.contact.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;
	public UserValidation verifyDetails(Login login) {
		
		
		UserValidation validation = null;
		
		// TO handle NoSuchElementException..
		try {
			
//			System.out.println("1");
			// Get user from database.  In case of no such user, it will throw NoSuchElementException.
			Login userFromDatabase = loginrepository.findById(login.getUsername()).get();	
			
//			System.out.println("2");
			
			boolean userExist = (userFromDatabase != null);
			
			// Perform password verification.  
			@SuppressWarnings("null")
			boolean passwordVerification = userFromDatabase.getPassword().equals(login.getPassword());
			
			// If both user existence and password verification are successful, set the validation object.
			validation = new UserValidation(userExist,passwordVerification,userFromDatabase);
			

		}
		catch(Exception e)
		{
//			System.out.println("3");
			
			e.printStackTrace();
			// If any exception occurs, return false for both user existence and password verification.
			return new UserValidation(false,false,null);
		}
		
		
		return validation;
		
	}
	
}
