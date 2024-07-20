package com.contact.service;

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
	
//	GlobalUserId currentUserid = 
	public void addContact(Contact contact) {
		contact.setU_id(null);
		System.out.println(contact.toString());
		contactrepository.save(contact);
		
	}
	
	public Contact getContactDetails(String id) {
		List<Contact> contactDetails = null;
		Contact contact = null;
		try {
		    contact = contactrepository.findById(id).get();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return contact;
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
