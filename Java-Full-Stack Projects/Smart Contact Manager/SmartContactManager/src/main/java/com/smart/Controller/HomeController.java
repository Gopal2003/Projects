package com.smart.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.doa.UserRepository;
import com.smart.entities.User;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	@GetMapping("/test")
//	@ResponseBody
//	public String test() {
//		
//		User user = new User();
//		user.setName("Gopal Agarwal");
//		user.setEmail("gopalmittal234@gmail.com");
//		
//		userRepository.save(user);
//		return "Working";
//	}
	
	//Home Handler
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home"; //this return the template file of the same name present in template folder
	}
	
	//About handler
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}
	
	//SignUp Handler
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register - Smart Contact Manager");
		return "signup";
	}
}
