package com.contact;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.services.UserService;

@RestController
public class userController {
	
//	@Autowired
//	private UserService userservice;
	
	@GetMapping("/user")
	public String getUsers()
	{
		return "Hi, This is working!";
	}
}
