package com.account.AccountService.Entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Data
@Entity
@Table(name = "Account_Table") //is a corresponding table that matches that entity in the database // for specifies class is an entity and is mapped to a database table.
public class Account {
	//use to make primary key
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int accountno;
	@Column(name="Money")
	private int money;
	
	 @OneToOne(mappedBy = "account")
	    @JsonBackReference
	    private Customer customer;


	 

	}

