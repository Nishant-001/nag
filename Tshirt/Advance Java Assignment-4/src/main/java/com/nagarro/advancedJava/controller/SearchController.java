package com.nagarro.advancedJava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.advancedJava.domain.TShirtDetails;
import com.nagarro.advancedJava.service.FilterData;

@Controller
public class SearchController {
	
	static List<TShirtDetails> list = new ArrayList<TShirtDetails>() ;
	
	@Autowired
	FilterData filterData;

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("color") String color, @RequestParam("size") String size, 
								@RequestParam("gender") String gender, @RequestParam("preference") String preference) throws IllegalStateException, IOException{
		
		ModelAndView mv = new ModelAndView();
		
		// setting the correct format
		color=getColor(color);
		size=getSize(size);
		gender=getGender(gender);
		preference=getPreference(preference);		
		
		// filer the T-Shirt products and storing them in a list
		list =  this.filterData.filter(color, size, gender, preference) ;
		
		String result= "Sorry!!! No Items Found.";
		mv.addObject("notFound", result);
		mv.setViewName("search");
		return mv;									
	}
	
	// returns the list of matched products
	public static List<TShirtDetails> getList() {
		return list;
	}
	
	// returns correct format of color
	public String getColor(String color) {
		String first =  color.substring(0,1);
		String last =   color.substring(1);
		color =  first.toUpperCase()+ last.toLowerCase();
		return color;
	}
	// returns correct format of size
	private String getSize(String size) {
		size=size.toUpperCase();
		return size;
	}
	// returns correct format of gender
	private String getGender(String gender) {
		gender=gender.toUpperCase();
		return gender;
	}
	// returns correct format of preference
	private String getPreference(String preference) {
		String first =  preference.substring(0,1);
		String last =   preference.substring(1);
		preference =  first.toUpperCase()+ last.toLowerCase();
		return preference;
	}
}
