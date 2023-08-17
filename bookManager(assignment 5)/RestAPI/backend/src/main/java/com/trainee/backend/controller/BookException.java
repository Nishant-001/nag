package com.trainee.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trainee.backend.exception.BookNotFoundException;
import com.trainee.backend.model.LibraryBook;

@ControllerAdvice
public class BookException {
	@ExceptionHandler(value =BookNotFoundException.class)
	public ResponseEntity<LibraryBook> exception(BookNotFoundException exception) {
		return new ResponseEntity("Employee not found",HttpStatus.NOT_FOUND);
	} 
}
