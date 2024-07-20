package com.contact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contactController {
	
	@GetMapping("/contact")
	public String test()
	{
		return "Contact controller tested";
	}
}
