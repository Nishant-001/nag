package com.Bank.BankingManagementNew.Controller;

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

import com.Bank.BankingManagementNew.Entities.Account;
import com.Bank.BankingManagementNew.Entities.Customer;

import com.Bank.BankingManagementNew.Services.CustomerService;



@RestController
public class CustomerController {
	
	 @Autowired
	    private CustomerService customerService;
	

	    // get all Customer handler
	    @GetMapping("/customer")
	    public ResponseEntity<List<Customer>> getBooks() {
			return ResponseEntity.of(Optional.of(customerService.getAllBooks()));
			
	    }
	
	    //Get a single Book
	    @GetMapping("/customer/{id}")
	    public Customer getCustomer(@PathVariable int id){
	    	return this.customerService.getCustomerByd(id);
	    }
	    
	    
	    @PostMapping("/customer")
	    public ResponseEntity<Customer> addBook(@RequestBody Customer customer) {
		        Customer b = null;
		        try {
		            b = this.customerService.addCustomer(customer);
//		            System.out.println(customer);
		            return ResponseEntity.status(HttpStatus.CREATED).build();
		        } catch (Exception e) {
		            // TODO: handle exception
		            e.printStackTrace();
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		        }

		    }
			

		//Update a Book
		@PutMapping("customer/{id}")
		public void updateBook(@RequestBody Customer customer,@PathVariable int id) {
			this.customerService.updateBook(customer,id);
			
		}
		
		//Delete a Books
		@DeleteMapping("customer/{id}")
		public void deleteBook(@PathVariable int id) {
			this.customerService.deletecustomer(id);
			
	}
			
			



}
