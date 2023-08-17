package com.trainee.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.trainee.backend.model.LibraryUser;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, String> {
	
	public LibraryUser findByUsernameAndPassword(String username , String password);
}
