package com.account.AccountService.dao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.account.AccountService.Controller.Exceptions.NegativeBalanceException;
import com.account.AccountService.Entities.Account;
import com.account.AccountService.Entities.Customer;
import com.account.AccountService.dao.AccountRepositery;
import com.account.AccountService.dao.CustomerRepositery;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@Component
public class AccountService {
	
	@Autowired
	 AccountRepositery accountRepositery;
	@Autowired
	CustomerRepositery customerRepositery;

	public void addMoney(int id, int Currentmoney) {
		// TODO Auto-generated method stub
//		List<Customer> list=(List<Customer>)this.customerRepositery.findAll();
		
		Customer ctsCustomer=null;
		 List<Customer> customers = (List<Customer>) customerRepositery.findAll();
	        for (Customer customer : customers) {
	            Account account = customer.getAccount();
	            if (account != null && account.getAccountno()==id) {
	                int moneys = account.getMoney();
	                moneys += Currentmoney;
	                account.setMoney(moneys);
	                customerRepositery.save(customer);
	                ctsCustomer=customer;
	            }
	        }
	        
	    }
	
	public Customer withdrawmoney(int id, int Currentmoney) {
		// TODO Auto-generated method stub
//		List<Customer> list=(List<Customer>)this.customerRepositery.findAll();
		
		Customer ctsCustomer=null;
		 List<Customer> customers = (List<Customer>) customerRepositery.findAll();
	        for (Customer customer : customers) {
	            Account account = customer.getAccount();
	            
	            
	            
	            
	            if (account != null && account.getAccountno()==id) {
	            	
	            	
	                int moneys = account.getMoney();
	                if (Currentmoney > moneys) {
	                    throw new NegativeBalanceException("Insufficient funds.");
	                }

	                
	                moneys -= Currentmoney;
	                account.setMoney(moneys);
	                customerRepositery.save(customer);
	                ctsCustomer=customer;
	            }
	        }
	        return ctsCustomer;
	    }
	
		
	public Customer getdetails(int id){
		 List<Customer> customers = (List<Customer>) customerRepositery.findAll();
	Customer customerfinal=null;
	for (Customer customer : customers) {
        Account account = customer.getAccount();
        if (account.getAccountno()==id) {
        	customerfinal=customer;
        	return customerfinal;
        }
        break;
		}
	return customerfinal;
	}
	
	
	   public void deleteAccount(int bid) {
	        // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		   int id=Integer.MAX_VALUE;
		   List<Customer> customers = (List<Customer>) customerRepositery.findAll();
	        for (Customer customer : customers) {
	        	if(customer.getAccount().getAccountno()==bid) {
	        		id=customer.getId();
	        	}
	        }
	         if(id!=Integer.MAX_VALUE) {
	        	 customerRepositery.deleteById(id);	        	 
	         }
	            
	    }
	   	
}


	
//	 public List<Account> getAllBooks() {
//	        List<Account> list=(List<Account>)this.customerRepositery.findAll();
//	        return list;
//	    }

	
	
	


