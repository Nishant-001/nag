package com.trainee.frontend.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.trainee.frontend.model.LibraryBook;

@Service
@Transactional
public class MainService {
	@Autowired
	private RestTemplate restTemplate;

	private String BOOK_API = "http://localhost:8092/";
	private String USER_API = "http://localhost:8092/login";

	public LibraryBook searchBook(String bcode) {
		String url = BOOK_API + "/searchbooks/{bcode}";
		LibraryBook book = restTemplate.getForObject(url, LibraryBook.class, bcode);
		return book;
	}

	public void updateBook(String bcode) {
		String url = BOOK_API + "/updatebook/{bcode}";
		restTemplate.put(url, LibraryBook.class, bcode);
	}

	public LibraryBook addBook(LibraryBook book) {
		String url = BOOK_API + "/addbook/";
		LibraryBook bookadded = restTemplate.postForObject(url,book,LibraryBook.class);
		return bookadded;
	}

	public List<LibraryBook> getAllBook() {
		String url = BOOK_API + "/books";

		List<LibraryBook> list = new ArrayList();
		LibraryBook[] book = restTemplate.getForObject(url, LibraryBook[].class);
		for (LibraryBook singlebook : book) {
			list.add(singlebook);
		}
		return list;
	}

	public void bookDelete(String bcode) {
		String url = BOOK_API + "/deletebook/{bcode}";
		this.restTemplate.delete(url, bcode);
		System.out.println("deleted");
	}

	public boolean login(String username,String password) {

		String url = USER_API + "/{username}/{password}";
		
		
		//RestTemplate template = new RestTemplate();
		
		LibraryBook user = (LibraryBook) restTemplate.getForObject(url, LibraryBook.class, username,password);
		
		if(user!= null)
			return true;
		return false;
	}

}
