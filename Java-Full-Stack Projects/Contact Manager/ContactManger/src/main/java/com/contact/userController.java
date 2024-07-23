package com.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entities.User;
import com.contact.service.UserService;
//import com.services.UserService;

@RestController
public class userController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/getuser")
	public List<User> getUsers()
	{
		List<User> CurrentUserDetails = userservice.getUserDetails();
		return CurrentUserDetails;
	}
	
//	@GetMapping(value = "/getusertest/{id}", produces = "application/json")
//	public User getUserTest(@PathVariable String id)
//	{
//		User test = userservice.getUserTest(id);
//		
//		return test;
//	}
	
	@PutMapping("/updateuser")
	public String updateUser(@RequestBody User user)
	{
		String message = userservice.updateUserDetails(user);
		return message;
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable Integer id)
	{
		userservice.deleteUserDetails(id);
		return "User Deleted Successfully.";
	}
}
