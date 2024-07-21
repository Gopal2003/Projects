package com.contact.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.CustomHelperClasses.GlobalUserId;
import com.contact.entities.Contact;
import com.contact.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;
	

	GlobalUserId currentUserLogginedId = GlobalUserId.getInstace();
	
	public void addContact(Contact contact) {
		
	
		String currentUserId = currentUserLogginedId.getCurrentUserId();
		
		System.out.println("Current User Id: " + currentUserId );
		
		contact.setU_id(currentUserId);
		System.out.println(contact.toString());
		contactrepository.save(contact);
		
	}
	
	public List<Contact> getContactDetails() {
		
		String currentUserId = currentUserLogginedId.getCurrentUserId();

		try {
//			return contactrepository.findByu_id(currentUserId);
			return Collections.emptyList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return Collections.emptyList();
		}
		
	}
	
	public void updateContactDetails(Contact contact)
	{
		contactrepository.save(contact);
	}
	
	public void deleteContact(String id)
	{
		contactrepository.deleteById(id);
	}

	
	
}
