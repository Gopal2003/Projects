package com.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entities.Contact;
import com.contact.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	@PostMapping("/addcontact")
	public String addContact(@RequestBody Contact contact)
	{
		contactservice.addContact(contact);
		return "Conact Added Successfully!!";
	}
	
	
	@GetMapping("/getcontact/{id}")
	public Contact showContact(@PathVariable String id)
	{
//		List<Contact> contactDetails = contactservice.getContactDetails(id);
		Contact contactDetails = contactservice.getContactDetails(id);
		
		return contactDetails;
	}
	
	@PutMapping("/updatecontact/{id}")
	public String updateContact(@RequestBody Contact contact)
	{
		contactservice.updateContactDetails(contact);
		return "Contact Updated Successfully";
	}
	
	@DeleteMapping("/deletecontact/{id}")
	public String deleteContact(@PathVariable String id)
	{
		contactservice.deleteContact(id);
		return "Contact Deleted Successfully";
	}
}
