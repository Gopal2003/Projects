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
			
			Login userFromDatabase = loginrepository.findById(login.getUsername()).get();	
			
//			System.out.println("2");
			
			boolean userExist = (userFromDatabase != null);
			
			@SuppressWarnings("null")
			boolean passwordVerification = userFromDatabase.getPassword().equals(login.getPassword());
			
			validation = new UserValidation(userExist,passwordVerification,userFromDatabase);
			
//			if(userExist && passwordVerification)
//			{
//				return validation;
//			}
		}
		catch(Exception e)
		{
//			System.out.println("3");
			
			e.printStackTrace();
			return new UserValidation(false,false,null);
		}
		
		
		return validation;
		
	}
	
}
