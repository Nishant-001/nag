package com.trainee.frontend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LibraryUser {
	@Id
	private String username;
	private String password;
	
	
	public LibraryUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LibraryUser() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LibraryUser [username=" + username + ", password=" + password + "]";
	}
	
	
}
