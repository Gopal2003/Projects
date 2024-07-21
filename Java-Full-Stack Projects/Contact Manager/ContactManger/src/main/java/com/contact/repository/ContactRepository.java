package com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.entities.Contact;

//public interface ContactRepository extends CrudRepository<Contact,String>{
//
//}


@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

	List<Contact> findByUserid(String userid);
}

