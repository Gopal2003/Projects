package com.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.contact.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact,String>{

}
