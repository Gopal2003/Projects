package com.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.contact.entities.User;
public interface UserRepository extends CrudRepository<User,Integer>{
	
}
