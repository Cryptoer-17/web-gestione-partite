package com.iaco2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iaco2code.springdemo.dao.PersonDAO;
import com.iaco2code.springdemo.entity.Persona;


@Controller
@RequestMapping("/person")
public class PersonController {

	
	//need to inject the person DAO
	@Autowired
	private PersonDAO personDAO;
		
	
	@RequestMapping("/pageForm")
	public String pageForm(Model theModel) {
		
		return "page-form";
	}
	
	
	@RequestMapping("/list")
	public String listPerson(Model theModel) {
		
		
		
		//get customer from the dao
		List<Persona> thePersons = personDAO.getPersons();
		
		//add the customers to the model
		theModel.addAttribute("persons",thePersons);
		
		
		return "list-person";
	}
	
	
	
}
