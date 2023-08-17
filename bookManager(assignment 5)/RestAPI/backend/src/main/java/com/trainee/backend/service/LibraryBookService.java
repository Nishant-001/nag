package com.trainee.backend.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trainee.backend.model.LibraryBook;
import com.trainee.backend.repository.LibraryBookRepository;


@Service
@Transactional
public class LibraryBookService {

	
	LibraryBookRepository bookRepository;
	public LibraryBookService(LibraryBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void addLibraryBook(LibraryBook libraryBook) {
		bookRepository.save(libraryBook);
	}
	public List<LibraryBook> showAllBook() {
		List<LibraryBook> book = new ArrayList<LibraryBook>();
		
		for(LibraryBook singlebook :bookRepository.findAll()) {
			book.add(singlebook);
		}
		return book;
		
	}
	
	public LibraryBook findByBcode(String id) {
		return bookRepository.findByBcode(id);
	}
	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}
}
