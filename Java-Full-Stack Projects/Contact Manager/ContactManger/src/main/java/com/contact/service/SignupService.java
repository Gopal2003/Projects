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
	
	public void addUser(User user) {
		userrepository.save(user);
		
		Login loginDetails = new Login(user.getName(),user.getPassword());
		
		System.out.println(loginDetails.getUsername() + " " + loginDetails.getPassword());
	
		loginrepository.save(loginDetails);
	}

}
