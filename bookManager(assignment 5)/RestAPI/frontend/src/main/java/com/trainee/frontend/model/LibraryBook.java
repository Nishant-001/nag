package com.trainee.frontend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class LibraryBook {
	@Id
	private String bcode;
	private String bname;
	private String bauthor;
	private String bdate;
	
	
	public LibraryBook() {
		super();
	}
	@Override
	public String toString() {
		return "LibraryBook [bcode=" + bcode + ", bname=" + bname + ", bauthor=" + bauthor + ", bdate=" + bdate + "]";
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public LibraryBook(String bcode, String bname, String bauthor, String bdate) {
		super();
		this.bcode = bcode;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bdate = bdate;
	}
	
	
	

}
