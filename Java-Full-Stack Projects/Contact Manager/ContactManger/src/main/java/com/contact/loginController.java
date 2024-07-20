package com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.CustomHelperClasses.Pair;
import com.contact.entities.Login;
import com.contact.service.LoginService;

@RestController
public class loginController {
	
	@Autowired
	private LoginService loginservice;
	
	
	@PostMapping("/login")
	public String test(@RequestBody Login login)
	{
		
		Pair isValidUser = loginservice.verifyDetails(login);
			if(isValidUser.isFirst() || isValidUser.isSecond())
			{
				if(!isValidUser.isFirst())
				{
					return "Username doesn't exist, Please Signup";
				}
				if(isValidUser.isFirst() && isValidUser.isSecond())
				{
					return "Welcome!";							
				}
				else if(!isValidUser.isSecond())
				{
					return "Wrong Password, Please try again!";
				}
			}			
		

		
		return "Username doesn't exist, Please Signup";
	}
	
}
