package com.account.AccountService.dao;

import org.springframework.data.repository.CrudRepository;


import com.account.AccountService.Entities.Account;


public interface AccountRepositery extends CrudRepository<Account,Integer>{
	 public Account findById(int id);   
	} 

