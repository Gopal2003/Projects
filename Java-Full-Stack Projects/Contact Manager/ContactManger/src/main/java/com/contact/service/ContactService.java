package com.contact.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.CustomHelperClasses.CurrentUserId;
import com.contact.entities.Contact;
import com.contact.repository.ContactRepository;

//Create a service for managing Contacts
@Service
public class ContactService {

	//Inject the contact repository
	@Autowired
	private ContactRepository contactrepository;
	
	//Get an instance of CurrentUserId to get current logged in user's id.
	CurrentUserId currentUserLogginedId = CurrentUserId.getInstace();
	
	public void addContact(Contact contact) {
		
		//Set current logged in user's id in contact's user_id field.
		Integer currentUserId = currentUserLogginedId.getCurrentUserId();
		
		// Printing current logged in user's id for testing purpose.  Commented out for now.
		// System.out.println("Current User Id: " + currentUserId );

		//Set current logged in user's id in contact's user_id field.
		contact.setU_id(currentUserId);

		// Printing the contact for testing purpose.  Commented out for now.
		// System.out.println(contact.toString());

		//Saving the contact to the database.
		contactrepository.save(contact);
		
	}
	
	public List<Contact> getContactDetails() {
		
		Integer currentUserId = currentUserLogginedId.getCurrentUserId();
		
		// Printing current logged in user's id for testing purpose.  Commented out for now.  
		//System.out.println("CurrentUserId: " + currentUserId);
		
		// To handle the exception when there is no contact found with the current user logged-in id, returning an empty list from database.
		try {
			return contactrepository.findByUserid(currentUserId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Collections.emptyList();
		}
		
	}
	// Method to update contact details.
	public void updateContactDetails(Contact contact)
	{
		contactrepository.save(contact);
	}
	
	// Method to delete contact details.
	public void deleteContact(Integer id)
	{
		contactrepository.deleteById(id);
	}

	
	
}
