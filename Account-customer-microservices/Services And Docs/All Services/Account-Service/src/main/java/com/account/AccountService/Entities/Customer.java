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
@Table(name="Customer_details")
public class Customer {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name = "first_name")
	private String fname;
	@Column(name = "last_name")
	private String lname;
	@Column(name = "Gmail")
	private String Email;
	@Column(name = "Customer_Address")
	private String Adreess;
	@Column(name = "Customer_phoneNo")
	private String phoneNo;
	
	
    @JsonManagedReference 
	@OneToOne(cascade = CascadeType.ALL) 
    private Account account;



    
}
