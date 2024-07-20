package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.CustomHelperClasses.Pair;
import com.contact.entities.Login;
import com.contact.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginrepository;
	public Pair verifyDetails(Login login) {
		
		Pair validation = null;
		// TO handle NoSuchElementException..
		try {
			
//			System.out.println("1");
			
			Login userFromDatabase = loginrepository.findById(login.getUsername()).get();	
			
//			System.out.println("2");
			
			boolean userExist = (userFromDatabase != null);
			
			@SuppressWarnings("null")
			boolean passwordVerification = userFromDatabase.getPassword().equals(login.getPassword());
			
			validation = new Pair(userExist,passwordVerification);
			
			if(userExist && passwordVerification)
			{
				return validation;
			}
		}
		catch(Exception e)
		{
//			System.out.println("3");
			
			e.printStackTrace();
			return new Pair(false,false);
		}
		
		
		return validation;
		
	}
	
}
