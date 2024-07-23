package com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entities.User;
import com.contact.service.SignupService;

@RestController
public class SignupController {
	
	@Autowired
	private SignupService signupservice;
	
	@PostMapping("/signup")
	public String createUser(@RequestBody User user)
	{
		int confirmationCode = signupservice.addUser(user);
		
		if(confirmationCode == 2)
		{
			return "User Already Exists!, Try with different id.";
		}
		if(confirmationCode == 0)
		{
			return "User Created Successfully!";			
		}
		
		else if(confirmationCode == 3)
		{
			return "Username Already Exist! Try with different name";
		}
		else if(confirmationCode == 1)
		{
			return "User Already Exists With the Same Email Address. Please Change Email Address and Try again.";
		}
		
		return "";
	}
	
}
