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
		signupservice.addUser(user);
		return "User Created Successfully!";
	}
	
}