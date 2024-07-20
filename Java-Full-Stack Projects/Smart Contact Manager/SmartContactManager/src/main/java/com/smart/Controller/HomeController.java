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
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	// @Valid is used to validate the user input. If any input fails validation, it will re-render the signup page with error messages.
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,@RequestParam(value="agreement",defaultValue = "false") boolean agreement, Model model,HttpSession session) {

		try{

			// further checks or additional validations before saving user in the database. For instance, checking if the user already exists or the password matches the criteria. If any of these checks fail, throw an exception and re-render the signup page with error messages.
			if(!agreement) { // check if agreement is not agreed
				System.out.println("Agreement not agreed. Registration rejected!  Please agree to the terms and conditions. Redirecting to signup");// redirect to signup page with error message
				throw new Exception("Agreement not agreed!");// rethrow the exception to show user an error message in signup page
			}

			// save user if all validations are passed. Validation will have already occurred on the frontend side. In this case, I am just showing how to handle it in case of backend validation failure.
			if(result.hasErrors())
			{
				System.out.println("Validation Errors Occurred! " + result.toString()); // print validation errors for debugging purpose.
				model.addAttribute("user",user); // add user details in model for displaying on the error page if any validation errors.
				return "signup"; // if any validation errors, re-render the signup page with error messages.
			}

			user.setRole("ROlE_USER");// set role as USER by default
			user.setEnabled(true); // set enabled as true by default
			user.setImageUrl("default.jpg"); // set default image URL

			
			System.out.println("Agreement " + agreement);// print agreement status for debugging purpose
			System.out.println("User Details: " + user);// print user details for debugging purpose


			User result1 = this.userRepository.save(user); // saving user to database
			model.addAttribute("user",new User()); // add user details in model for displaying on the success page
			session.setAttribute("message",new Message("Congratulations! You have registered Successfully","alert-success"));// setting message for success page

			return "signup";// return template name
		}
		catch(Exception e){
            e.printStackTrace();// print error details for debugging purpose
			model.addAttribute("user",user);// add user details in model for displaying on the error page
			session.setAttribute("message",new Message("OOPS! An error occurred while registering. Reason:  " + e.getMessage(),"alert-danger"));// setting message for error page
        }
        return "signup"; // return template name
	}
}
