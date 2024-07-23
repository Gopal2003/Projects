package com.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	User findByid(String id);
	
	User findByemail(String email);

	User findByname(String name);
}
