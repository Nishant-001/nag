package com.Bank.BankingManagementNew.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.BankingManagementNew.Entities.Account;
import com.Bank.BankingManagementNew.Entities.Customer;
import com.Bank.BankingManagementNew.dao.CustomerRepositery;



@Component
public class CustomerService {
	
	  @Autowired
	    private CustomerRepositery customerRepositery;

	  
	  
	    public List<Customer> getAllBooks() {
	        List<Customer> list=(List<Customer>)this.customerRepositery.findAll();
	        return list;
	    }

	    public Customer getCustomerByd(int id) {
	    	Customer cust = null;
	    	try {
	    		// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
	    		cust=this.customerRepositery.findById(id);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return cust;
	    	
	    }

	    
//	    2
		public Customer addCustomer(Customer customer) {
			// TODO Auto-generated method stub
			
			Customer result=null;
			try {
	    		// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
				result=customerRepositery.save(customer);
				return result;
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
			return result;
		}
		
		
	    // update the book
	    public void updateBook(Customer customer, int custId) {
	        customer.setId(custId);
	        customerRepositery.save(customer);
	    }

	    public void deletecustomer(int bid) {
	        // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
	        customerRepositery.deleteById(bid);
	    }

		
	    
}
