package com.trainee.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.backend.model.LibraryBook;
import com.trainee.backend.model.LibraryUser;
import com.trainee.backend.service.LibraryBookService;
import com.trainee.backend.service.LibraryUserService;

@RestController
public class LibraryController {
	@Autowired
	LibraryUserService libraryUserService;
	@Autowired
	LibraryBookService libraryBookService;
	List<LibraryBook> books;
	// list of books


	@GetMapping(value = "/login/{username}/{password}")
	public ResponseEntity<LibraryUser> getUser(@PathVariable("username") String username,@PathVariable("password")String password) {
		//Login login = service.getLogin(id);
		LibraryUser u= libraryUserService.findByUsernameAndPassword(username, password);
		if (u == null) {
			u = new LibraryUser();
			return new ResponseEntity<LibraryUser>(u, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<LibraryUser>(u, HttpStatus.OK);
		}
	
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<LibraryUser>> getAllUser() {
		// Login login = service.getLogin(id);
		List<LibraryUser> list = new ArrayList();
		list = libraryUserService.getAllUser();

		if (list.isEmpty()) {
			// u = new User();
			System.out.println("Nothing");
			return new ResponseEntity<List<LibraryUser>>(list, HttpStatus.NOT_FOUND);

		} else {
			for (LibraryUser user : list) {
				System.out.println(user);
			}
			return new ResponseEntity<List<LibraryUser>>(list, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/books")
	public ResponseEntity<List<LibraryBook>> getAllBooks() {
		books = libraryBookService.showAllBook();
		if (books.isEmpty())
			books = new ArrayList();
		return new ResponseEntity<List<LibraryBook>>(books, HttpStatus.OK);
	}

	@PostMapping(value = "/addbook")
	public ResponseEntity<LibraryBook> addBook(@RequestBody LibraryBook book) {
		System.out.println(book);
		libraryBookService.addLibraryBook(book);
		return new ResponseEntity<LibraryBook>(book, HttpStatus.CREATED);

	}

	@GetMapping(value = "/searchbooks/{bcode}")
	public ResponseEntity<LibraryBook> searchBook(@PathVariable("bcode") String bcode) {
		LibraryBook getbook = libraryBookService.findByBcode(bcode);
		return new ResponseEntity<LibraryBook>(getbook, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deletebook/{bcode}")
	public ResponseEntity<LibraryBook> DeleteBook(@PathVariable("bcode") String bcode) {
		libraryBookService.deleteBook(bcode);
		return new ResponseEntity<LibraryBook>(HttpStatus.OK);

	}

}
