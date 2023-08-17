package com.account.AccountService.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.AccountService.Entities.Customer;
import com.account.AccountService.dao.services.AccountService;



@RestController
public class AccountController {
	
	 @Autowired
	    private AccountService accountService;

//	     get all Customer handler
	    @PutMapping("/account/{id}/money/{money}")
	    public void adddMoneyToAccount(@PathVariable int id,@PathVariable int money) {
	    	this.accountService.addMoney(id, money);
	    	
	    }
	    
	    @PutMapping("/account/{id}/wmoney/{money}")
	    public void withdrawmoney(@PathVariable int id,@PathVariable int money) {
	    	this.accountService.withdrawmoney(id, money);
	    	
	    }
	    
	    @GetMapping("account/{id}")
	    public Customer getDetailsById(@PathVariable int id) {
	        	return this.accountService.getdetails(id);
//	            System.out.println(customer);
	      
	    }
	    
		@DeleteMapping("account/{id}")
		public void deleteBook(@PathVariable int id) {
			this.accountService.deleteAccount(id);
			
	}
			
		
	    
	 

}
