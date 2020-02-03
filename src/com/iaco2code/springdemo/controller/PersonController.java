package com.iaco2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		
	
	@GetMapping("/pageForm")
	public String pageForm(Model theModel) {
		
		//create model attrubute to bind form data
				Persona thePerson = new Persona();
				theModel.addAttribute("person",thePerson);
		
		return "page-form";
	}
	
	
	
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Persona thePerson) {
		
		personDAO.savePerson(thePerson);
		
		return "redirect:/person/ShowPrimaryPage";
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
		
		//get list event from DAO 
		List<Evento> events=personDAO.getEvents();
		
		

		//add the list to the model  
		theModel.addAttribute("eventi",events);
		
		return "primary-page";
	}
	
	
	@GetMapping("/showFormForLogin")
	public String showFormForLogin (Model theModel) {
		
		Persona thePerson = new Persona();
		
		theModel.addAttribute("person",thePerson);
		
		return "person-login";
	}
	
	 @GetMapping("/search")
	    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {
		
		//get event from the dao
		 List<Evento> theEvent = personDAO.getEvent(theSearchName);
	
		 //add the event to the model  
		 theModel.addAttribute("eventos",theEvent);
	
			
			
			
			//get person from the dao
			List<Persona> thePersons = personDAO.getPersons(theSearchName);
			
			//add the person to the model
			theModel.addAttribute("persons",thePersons);

	        return "list-person";        
	    }
	
	
}
