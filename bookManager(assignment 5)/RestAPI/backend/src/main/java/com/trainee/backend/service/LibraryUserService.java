package com.trainee.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.trainee.backend.repository.*;
import com.trainee.backend.model.LibraryUser;

@Service
@Transactional
public class LibraryUserService {
	LibraryUserRepository repository;
	public LibraryUserService(LibraryUserRepository repository) {
		this.repository = repository;
	}
	
	public void saveLibraryUser(LibraryUser libraryUser) {
		repository.save(libraryUser);
	}
//	public List<LibraryUser> getAllUser(LibraryUser libraryUser) {
//		return repository.findAll()(libraryUser.getUsername());
//		
//	}
//	
	public List<LibraryUser> getAllUser(){
		List<LibraryUser> list=new ArrayList<LibraryUser>();
		list=(List<LibraryUser>) repository.findAll();
		return list;
		
	}
	public LibraryUser findByUsernameAndPassword(String username,String password) {
		return repository.findByUsernameAndPassword(username, password);
	}
}
