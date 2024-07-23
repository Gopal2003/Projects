package com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.entities.Contact;



//I am using JpaRepository interface provided by Spring Data JPA to interface with our database. This is helpful in terms of CRUD operations and providing a custom query which converts the method name into the query.
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	//This method is used to fetch all contacts for a given user. We use Integer type here as it is our primary key in our Contact entity.
	List<Contact> findByUserid(Integer userid);
}

