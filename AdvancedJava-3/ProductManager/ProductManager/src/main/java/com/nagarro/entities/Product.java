package com.nagarro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column
	private String title_c;
	
	@Column
	private int quantity_c;
	
	@Column
	private int size_c;
	
	@Column
	String imagePath_c;
	
	public String getImagePath_c() {
		return imagePath_c;
	}
	public void setImagePath_c(String imagePath_c) {
		this.imagePath_c = imagePath_c;
	}
	public String getTitle_c() {
		return title_c;
	}
	public void setTitle_c(String title_c) {
		this.title_c = title_c;
	}
	public int getQuantity_c() {
		return quantity_c;
	}
	public void setQuantity_c(int quantity_c) {
		this.quantity_c = quantity_c;
	}
	public int getSize_c() {
		return size_c;
	}
	public void setSize_c(int size_c) {
		this.size_c = size_c;
	}
}
