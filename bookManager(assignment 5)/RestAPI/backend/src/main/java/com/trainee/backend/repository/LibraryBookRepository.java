package com.trainee.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.trainee.backend.model.LibraryBook;



public interface LibraryBookRepository extends CrudRepository<LibraryBook, String> {
	public LibraryBook findByBcode(String id);
}
