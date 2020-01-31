package com.iaco2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iaco2code.springdemo.dao.PersonDAO;
import com.iaco2code.springdemo.entity.Evento;
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
		
		
		//get the event grom the dao
		List<Evento> theEvent = personDAO.getEvent("Calcio");
		
		
		//add the event to the model  
		theModel.addAttribute("eventos",theEvent);
		
		//get person from the dao
		List<Persona> thePersons = personDAO.getPersons("Calcio");
		
		//add the person to the model
		theModel.addAttribute("persons",thePersons);
		
		
		
		
		return "list-person";
	}
	
	
	@GetMapping("/ShowPrimaryPage")
	public String ShowPrimaryPage (Model theModel) {
		
		return "primary-page";
	}
	
	
	 @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {
		 System.out.println("Qui");

		 List<Evento> theEvent = personDAO.getEvent(theSearchName);
			
		  if(theEvent.isEmpty()) {
			  theModel.addAttribute("eventos",theEvent);
		  } 
		  else theModel.addAttribute("eventos",theEvent);
			//add the event to the model  
			
			
			
			//get person from the dao
			List<Persona> thePersons = personDAO.getPersons(theSearchName);
			
			//add the person to the model
			theModel.addAttribute("persons",thePersons);

	        return "list-person";        
	    }
	
	
}
