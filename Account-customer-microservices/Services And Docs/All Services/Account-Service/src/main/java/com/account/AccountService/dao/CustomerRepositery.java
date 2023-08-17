package com.account.AccountService.dao;

import org.springframework.data.repository.CrudRepository;

import com.account.AccountService.Entities.Customer;



public interface CustomerRepositery extends CrudRepository<Customer,Integer>{
	 public Customer findById(int id);

}
