package com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.CustomHelperClasses.CurrentUserId;
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
		
		CurrentUserId currentUserId = CurrentUserId.getInstace();
		
		UserValidation isValidUser = loginservice.verifyDetails(login);
		
			if(isValidUser.isUsernameVerification() || isValidUser.isPasswordVerification())
			{
				if(!isValidUser.isUsernameVerification())
				{
					return "Username doesn't exist, Please Signup";
				}
				if(isValidUser.isUsernameVerification() && isValidUser.isPasswordVerification())
				{
					Login currentUserDetails = isValidUser.getCurrentUser();
					String userId = currentUserDetails.getUser_id();
					
					currentUserId.setCurrentUserId(userId);
					
					System.out.println("CurrentUserId: " + currentUserId.getCurrentUserId());
					return "Welcome Back! " + currentUserDetails.getUsername();							
				}
				else if(!isValidUser.isPasswordVerification())
				{
					return "Wrong Password, Please try again!";
				}
			}			
		

		
		return "Username doesn't exist, Please Signup";
	}
	
}
