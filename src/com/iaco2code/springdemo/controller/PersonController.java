package com.iaco2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iaco2code.springdemo.dao.PersonDAO;
import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;
import com.iaco2code.springdemo.sendemail.JavaMail;

@Controller
@RequestMapping("/person")
public class PersonController {

	
	// add an initbinder ... to cinvert trim imput string
	//remove leading and trailing whitespace
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
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
	
	
	
	@GetMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Persona thePerson) {
		personDAO.savePerson(thePerson);
		
		return "redirect:/person/ShowPrimaryPage";
	}
	
	@PostMapping("/attendPerson")
	public String attendPerson(
			@Valid @ModelAttribute("person") Persona thePerson,
			BindingResult theBindingResult,
			Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "page-form";
		}
		else {
		String email = thePerson.getEmail();
		System.out.println(thePerson.getNome());
		JavaMail.send_email(email,"123456");
		theModel.addAttribute("person",thePerson);
		return "attend-person";
		}
	}
	
	@PostMapping("/confirmCode")
	public String confirmCode(@ModelAttribute("person") Persona thePerson,@RequestParam("theCodeUser") String theCodeUser,Model theModel) {
		if(theCodeUser.equals("123456")) {
			//salva la persona nel db e ritorna la pagina primaria
			personDAO.savePerson(thePerson);
			return "redirect:/person/ShowPrimaryPage";
		}
		else //messaggio di errore e rimani in quella pagina per ora
			return "attend-person";
	
	}
	
	 @GetMapping("/search")
	    public String search(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search customers from the service
	        List<Evento> theEvents = personDAO.getEvent(theSearchName);
	                
	        // add the customers to the model
	      
	        theModel.addAttribute("eventos", theEvents);

	        return "list-person";        
	    }
	
	@PostMapping("/listPerson")
	public String listPerson(@RequestParam("theId") int theId,@RequestParam("theSearchName") String theSearchName,Model theModel) {
		
		
		//get person id session from the dao
		Persona thePers = personDAO.getPersonsId(theId);
		List<Persona> thePerson = new ArrayList<Persona>();
		thePerson.add(thePers);
		//add the person to the model
		theModel.addAttribute("person",thePerson);
		

		//get the event grom the dao
		List<Evento> theEvent = personDAO.getEvent(theSearchName);	
		//add the event to the model  
		theModel.addAttribute("eventos",theEvent);
		
		
		//get person from the dao
		List<Persona> thePersons = personDAO.getPersons(theSearchName);
		//add the person-event to the model
		theModel.addAttribute("persons",thePersons);		
		
	
		
		return "list-person";
	}
	
	
	
	@GetMapping("/ShowPrimaryPage")
	public String ShowPrimaryPage (Model theModel) {
	    List<Persona> thePers = (List<Persona>) theModel.asMap().get("some");
	  
	    theModel.addAttribute("person",thePers);

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
	
	@PostMapping("/partecipatePerson")
	public String partecipatePerson(@RequestParam("theIdPers") int idPers ,
									@RequestParam("theIdEvent") int idEvent,
									Model theModel) {
		personDAO.assocPersEvent(idPers,idEvent);
		
		Persona thePers = personDAO.getPersonsId(idPers);
		List<Persona> person = new ArrayList<Persona>();
		person.add(thePers);
		theModel.addAttribute("person",person);
		
		String tipo = personDAO.getTipoEvent(idEvent);
		System.out.println(tipo);
		
		List<Evento> theEvent = personDAO.getEvent(tipo);	
		//add the event to the model  
		theModel.addAttribute("eventos",theEvent);
		
		
		//get person from the dao
		List<Persona> thePersons = personDAO.getPersons(tipo);
		//add the person-event to the model
		theModel.addAttribute("persons",thePersons);
				
		
		return "list-person";
	}
	

	@PostMapping("/nonPartecipatePerson")
	public String nonPartecipatePerson(@RequestParam("theIdPers") int idPers,
										@RequestParam("theIdEvent") int idEvent,
										Model theModel){
		
		Persona thePers = personDAO.getPersonsId(idPers);
		Evento thEvent = personDAO.getEventId(idEvent);
		personDAO.deleteAssocEventPers(thePers,thEvent);
		Persona tempPers= new Persona(thePers.getNome(),thePers.getCognome(),thePers.getEmail(),thePers.getUsername(),thePers.getPassword());
		personDAO.savePerson(tempPers);
		
		return "page-form";
	}
	
	 @PostMapping("/confirmPerson")
	    public String confirmPerson(@RequestParam("theUserPers") String theUserPers,
	    								@RequestParam("theUserPass") String theUserPass,
	    								RedirectAttributes redirectAttrs,
	                                    Model theModel) {
		
	
		//get event from the dao
		Persona thePers = personDAO.checkPerson(theUserPers,theUserPass);
		List<Persona> list = new ArrayList<Persona>();
		list.add(thePers);
		if(thePers!=null) {
			redirectAttrs.addFlashAttribute("some", list);
			return "redirect:/person/ShowPrimaryPage";  
		}
		else {
			return "person-login"; 
		}
	    }
	
	
}
