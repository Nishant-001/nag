package com.trainee.frontend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.trainee.frontend.model.LibraryBook;
import com.trainee.frontend.model.LibraryUser;
import com.trainee.frontend.service.MainService;
@RestController
public class FrontController {
	@Autowired
	MainService libraryBookService;
	List<LibraryBook> books;
	static String uname;
	
	Date date = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
  	String strdate = formatter.format(date);
	
	@RequestMapping("/")
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView();
			mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest request,@RequestParam String username,@RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		uname = username;
		System.out.println(username+" "+password);
		System.out.println(strdate);
		if(libraryBookService.login(username, password)) {
			books = libraryBookService.getAllBook();
			System.out.println(books );
			mv.addObject("books",books);
			mv.addObject("username",uname);
			mv.addObject("login","Login Successful");
			mv.addObject("strdate",strdate);
			mv.setViewName("welcome");
		}
		else {
			mv.addObject("failed","wrong credentials");
			mv.setViewName("login");
		}
		return mv;
		
	}
//	@RequestMapping("/Register")
//	public ModelAndView RegisterUser(@RequestParam String username,@RequestParam String password) {
//		LibraryUser user = new LibraryUser(username,password);
//		libraryUserService.saveLibraryUser(user);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("msg","user saved ");
//		mv.setViewName("welcome");
//		return mv;
//		
//	}
	@RequestMapping("/bookpage") 
	public ModelAndView bookpage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addbook");
		mv.addObject("strdate",strdate);
		mv.addObject("username",uname);
		return mv;
	}
	
	@RequestMapping("/addbook")
	public ModelAndView addBook(@RequestParam String bcode,@RequestParam String bname ,@RequestParam String bauthor,@RequestParam String bdate) {
		System.out.println(bcode+" "+bname+" "+bauthor+" "+bdate);
		ModelAndView mv = new ModelAndView();
		if(bcode.isEmpty()||bname.isEmpty()||bauthor.isEmpty()||bdate.isEmpty()) {
			mv.addObject("msg","Please fill all fields");
			mv.setViewName("addbook");
			mv.addObject("username",uname);
		}
		else {
			LibraryBook  book = new LibraryBook(bcode,bname,bauthor,bdate);
			libraryBookService.addBook(book);			
			
			books = libraryBookService.getAllBook();
			System.out.println(books );
			mv.addObject("username",uname);
			mv.addObject("books",books);
			mv.addObject("msg","book saved ");
			mv.setViewName("welcome");
		}
		
		mv.addObject("strdate",strdate);
		return mv;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam String id) {
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		LibraryBook book  = libraryBookService.searchBook(id);
		System.out.println(book);
		mv.addObject("book",book);
		mv.addObject("strdate",strdate);
		mv.addObject("username",uname);
		mv.setViewName("edit");
		return mv;
		
	}

	@RequestMapping("/editbook")
	public ModelAndView editBook(@RequestParam String bcode,@RequestParam String bname ,@RequestParam String bauthor,@RequestParam String bdate) {
		System.out.println(bcode+" "+bname+" "+bauthor+" "+bdate);
		ModelAndView mv = new ModelAndView();
		
		if(bcode.isEmpty()||bname.isEmpty()||bauthor.isEmpty()||bdate.isEmpty()) {
			LibraryBook book  = libraryBookService.searchBook(bcode);
			mv.addObject("msg","Please fill all fields");
			
			mv.setViewName("edit");
			mv.addObject("username",uname);
			mv.addObject("book",book);
		}
		else {
			LibraryBook  book = new LibraryBook(bcode,bname,bauthor,bdate);
			libraryBookService.addBook(book);			
			
			books = libraryBookService.getAllBook();
			System.out.println(books );
			mv.addObject("username",uname);
			mv.addObject("books",books);
			mv.addObject("msg","book saved ");
			mv.setViewName("welcome");
		}
		
		mv.addObject("strdate",strdate);
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView deleteBook(@RequestParam String id) {
		System.out.println(id);
		libraryBookService.bookDelete(id);
		ModelAndView mv = new ModelAndView();
		books = libraryBookService.getAllBook();
		System.out.println(books );
		mv.addObject("username",uname);
		mv.addObject("books",books);
		//mv.addObject("books",books);
		mv.setViewName("welcome");
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout","Logout Successfully");
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/cancel")
	public ModelAndView cancel() {
		ModelAndView mv = new ModelAndView();
		books = libraryBookService.getAllBook();
		System.out.println(books );
		mv.addObject("books",books);
		//mv.addObject("books",books);
		mv.setViewName("welcome");
		return mv;
	}
}
