package com.contact.repository;

import org.springframework.data.repository.CrudRepository;

import com.contact.entities.Login;


public interface LoginRepository extends CrudRepository<Login,String>{
	
}
