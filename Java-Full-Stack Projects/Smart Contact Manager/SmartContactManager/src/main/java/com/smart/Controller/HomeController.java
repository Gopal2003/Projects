package com.smart.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.doa.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
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
		model.addAttribute("title","Register - Smart Contact Manager");//We are passing a user object to the signup page using thymeleaf th:object property
		model.addAttribute("user", new User());//We will bind the user object to the signup page using thymeleaf th:object property
		return "signup";
	}

	//handler for registering user
	@RequestMapping(value= "/do_register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue = "false") boolean agreement, Model model,HttpSession session) {

		try{

			if(!agreement) { // check if agreement is not agreed
				System.out.println("Agreement not agreed. Registration rejected!  Please agree to the terms and conditions. Redirecting to signup");
				throw new Exception("Agreement not agreed!");
			}

			user.setRole("ROlE_USER");// set role as USER by default
			user.setEnabled(true); // set enabled as true by default
			user.setImageUrl("default.jpg"); // set default image URL

			System.out.println("Agreement " + agreement);
			System.out.println("User Details: " + user);


			User result = this.userRepository.save(user); // saving user to database
			model.addAttribute("user",new User()); // add user details in model for displaying on the success page
			session.setAttribute("message",new Message("Congratulations! You have registered Successfully","alert-success"));

			return "signup";// return template name
		}
		catch(Exception e){
            e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("OOPS! An error occurred while registering. Reason:  " + e.getMessage(),"alert-danger"));
        }
        return "signup"; // return template name
	}
}
