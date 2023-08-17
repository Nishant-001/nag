package com.Bank.BankingManagementNew.dao;

import org.springframework.data.repository.CrudRepository;

import com.Bank.BankingManagementNew.Entities.Account;
import com.Bank.BankingManagementNew.Entities.Customer;

public interface CustomerRepositery extends CrudRepository<Customer,Integer>{
	 public Customer findById(int id);

}
