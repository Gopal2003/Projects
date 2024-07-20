package com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.CustomHelperClasses.GlobalUserId;
import com.contact.CustomHelperClasses.UserValidation;
import com.contact.entities.Login;
import com.contact.service.LoginService;

@RestController
public class loginController {
	
	@Autowired
	private LoginService loginservice;
	
	
	@PostMapping("/login")
	public String test(@RequestBody Login login)
	{
		
		UserValidation isValidUser = loginservice.verifyDetails(login);
			if(isValidUser.isFirst() || isValidUser.isSecond())
			{
				if(!isValidUser.isFirst())
				{
					return "Username doesn't exist, Please Signup";
				}
				if(isValidUser.isFirst() && isValidUser.isSecond())
				{
					Login currentUserDetails = isValidUser.getCurrentUser();
					String userId = currentUserDetails.getUser_id();
					
					GlobalUserId currentUserId = new GlobalUserId(userId);
					
					System.out.println("CurrentUserId: " + currentUserId.getCurrentUser_Id());
					return "Welcome Back! " + currentUserDetails.getUsername();							
				}
				else if(!isValidUser.isSecond())
				{
					return "Wrong Password, Please try again!";
				}
			}			
		

		
		return "Username doesn't exist, Please Signup";
	}
	
}
