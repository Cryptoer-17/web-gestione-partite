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
import com.iaco2code.springdemo.daoevent.EventDAO;
import com.iaco2code.springdemo.entity.Evento;
import com.iaco2code.springdemo.entity.Persona;
import com.iaco2code.springdemo.sendemail.Code;
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
	
	@Autowired
	private EventDAO eventDAO;
	
	
	
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
	
	@GetMapping("/saveEvent")
	public String saveEvent(@ModelAttribute("evento") Evento theEvent,
							@RequestParam("theId") int theId,
							RedirectAttributes redirectAttrs,
							Model theModel) {
		
		
		System.out.println(theEvent);
		eventDAO.saveEvent(theEvent);
		
		Persona thePers = personDAO.getPersonsId(theId);
		redirectAttrs.addFlashAttribute("some", thePers);
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
		List<Persona> validPerson = personDAO.checkIfExistEmailOrUser(thePerson.getEmail(),thePerson.getUsername());
			if (validPerson.isEmpty()) {
			String email = thePerson.getEmail();
			System.out.println(thePerson.getNome());
			String codice = Code.generateCode();
			JavaMail.send_email(email,codice);
			theModel.addAttribute("prova",codice);
			theModel.addAttribute("person",thePerson);
			return "attend-person";
			}
			else 
			{
				theModel.addAttribute("lista",validPerson);
				return "page-form";
			}
		}
	}
	
	@PostMapping("/confirmCode")
	public String confirmCode(@ModelAttribute("person") Persona thePerson,
								@RequestParam("theCodeUser") String theCodeUser,
								@RequestParam ("theCode") String trueCode,
								RedirectAttributes redirectAttrs,
								Model theModel) {
		if(theCodeUser.equals(trueCode)) {
			//salva la persona nel db e ritorna la pagina primaria
			thePerson.setAdmin(0);
			personDAO.savePerson(thePerson);
			redirectAttrs.addFlashAttribute("some",thePerson);
			return "redirect:/person/ShowPrimaryPage";
		}
		else //messaggio di errore e rimani in quella pagina per ora
			return "attend-person";	
	}
	
	 @GetMapping("/search")
	    public String search(@RequestParam("theSearchName") String theSearchName,
	                                    Model theModel) {

	        // search customers from the service
	        List<Evento> theEvents = eventDAO.getEvent(theSearchName);
	                
	        // add the customers to the model
	      
	        theModel.addAttribute("eventos", theEvents);

	        return "list-person";        
	    }
	
	 
	 	@GetMapping("/listEventSearch")
		public String listEventSearch(@RequestParam("theId") int theId,@RequestParam("theSearchName") String theSearchName,Model theModel) {
			
			System.out.println("stampa");
			//get person id session from the dao
			Persona thePers = personDAO.getPersonsId(theId);
			//add the person to the model
			theModel.addAttribute("person",thePers);
			

			//get the event grom the dao
			List<Evento> theEvents = eventDAO.getEvent(theSearchName);	
			//add the event to the model  
			theModel.addAttribute("eventos",theEvents);

			Evento theEvent = new Evento();
			theModel.addAttribute("evento",theEvent);
			return "list-event-search";
		}
	 
	 
	@GetMapping("/listPerson")
	public String listPerson(@RequestParam("theIdEvent") int theIdEvent,@RequestParam("theId") int theId,Model theModel) {
		
	
		
		
		//get person id session from the dao
		Persona thePers = personDAO.getPersonsId(theId);
		List<Persona> thePerson = new ArrayList<Persona>();
		thePerson.add(thePers);
		
		
		//add the person to the model
		theModel.addAttribute("person",thePerson);
		
		
		//add the event to the model
		Evento theEvent = eventDAO.getEventId(theIdEvent);
		List<Evento> theEventList = new ArrayList<Evento>();
		theEventList.add(theEvent);
		theModel.addAttribute("eventos",theEventList);
		
		System.out.println(theEvent);
		
		//get person from dao associate that id
		List<Persona> thePersons = personDAO.getPersonsAssocEventId(theIdEvent);
		theModel.addAttribute("persons",thePersons);
	
		
		return "list-person";
	}
	
	
	@GetMapping("/linkListEventPrimary")
	public String linkListEventPrimary (@RequestParam("theId") int idPers,
										Model theModel,
										RedirectAttributes redirectAttributes) {
		Persona thePers = personDAO.getPersonsId(idPers);
		redirectAttributes.addFlashAttribute("some", thePers);
		return "redirect:/person/ShowPrimaryPage";
	}
	
	
	@GetMapping("/ShowPrimaryPage")
	public String ShowPrimaryPage (Model theModel/*,@PathVariable("person") int person*/) {
		

		
	    Persona thePers = (Persona) theModel.asMap().get("some");
	    theModel.addAttribute("person",thePers);

		//get list event from DAO 
		List<Evento> events=eventDAO.getEvents();	
		//add the list to the model  
		theModel.addAttribute("eventi",events);

		
		//get list person from DAO
		List<Persona> persons = personDAO.getAllPerson();
		//add the list to the model
		theModel.addAttribute("allPerson",persons);
		
		return "primary-page";
	}
	
	
	@GetMapping("/showFormForLogin")
	public String showFormForLogin (Model theModel) {
		
		Persona thePerson = new Persona();
		
		theModel.addAttribute("person",thePerson);
		
		return "person-login";
	}
	
	@GetMapping("/partecipatePerson")
	public String partecipatePerson(@RequestParam("theIdPers") int idPers ,
									@RequestParam("theIdEvent") int idEvent,
									Model theModel) {
		personDAO.assocPersEvent(idPers,idEvent);
		
		
		Persona thePers = personDAO.getPersonsId(idPers);
		List<Persona> person = new ArrayList<Persona>();
		person.add(thePers);
		theModel.addAttribute("person",person);
		
		String tipo = eventDAO.getTipoEvent(idEvent);
		
		List<Evento> theEvent = eventDAO.getSingleEvent(idEvent,tipo);	
		
		
		//add the event to the model  
		theModel.addAttribute("eventos",theEvent);
		
		
		//get person from the dao
		List<Persona> thePersons = personDAO.getPersons(tipo);
		//add the person-event to the model
		theModel.addAttribute("persons",thePersons);
				
		
		return "list-person";
	}
	

	@GetMapping("/nonPartecipatePerson")
	public String nonPartecipatePerson(@RequestParam("theIdPers") int idPers,
										@RequestParam("theIdEvent") int idEvent,
										Model theModel){
		
		Persona thePers = personDAO.getPersonsId(idPers);
		Evento thEvent = eventDAO.getEventId(idEvent);
		personDAO.deleteAssocEventPers(thePers,thEvent);
		Persona tempPers= new Persona(thePers.getNome(),thePers.getCognome(),thePers.getEmail(),thePers.getUsername(),thePers.getPassword(),thePers.getAdmin());
		personDAO.savePerson(tempPers);
		
		
		List<Persona> person = new ArrayList<Persona>();
		person.add(tempPers);
		theModel.addAttribute("person",person);
		
		String tipo = eventDAO.getTipoEvent(idEvent);
		
		List<Evento> theEvent = eventDAO.getSingleEvent(idEvent, tipo);	
		//add the event to the model  
		theModel.addAttribute("eventos",theEvent);
		
		//get person from the dao
		List<Persona> thePersons = personDAO.getPersons(tipo);
		//add the person-event to the model
		theModel.addAttribute("persons",thePersons);
		
		
		return "list-person";
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
			redirectAttrs.addFlashAttribute("some", thePers);
			return "redirect:/person/ShowPrimaryPage";  
		}
		else {
			return "person-login"; 
		}
	    }
	
	 
	 @GetMapping("/createEvent")
	 public String createEvent(Model theModel,@RequestParam("theId") int theId) {
		 
		//get person id session from the dao
			Persona thePers = personDAO.getPersonsId(theId);
			
			//add the person to the model
			 theModel.addAttribute("person",thePers);
			 
			 
			//get list event from DAO 
			List<Evento> events=eventDAO.getEvents();
			
			
			//add the list to the model  
			theModel.addAttribute("eventi",events);
			
			List<Persona> nullPerson= new ArrayList<Persona>();
			nullPerson.add(thePers);
			
			//add the list to the model  
			theModel.addAttribute("listcreatevent",nullPerson);
			
			//create model attrubute to bind form data
			Evento theEvent = new Evento();
			theModel.addAttribute("evento",theEvent);
				
		 return "primary-page";
	 }
	 
	 @GetMapping("/removeDaoEvent")
	 public String removeDaoEvent(Model thModel,
			 						@RequestParam("removeEvent") int theIdEvent,
			 						@RequestParam("theId") int theId,
			 						RedirectAttributes redirectAttrs) {
		 
		 Evento theEvent = eventDAO.getEventId(theIdEvent);
		 eventDAO.deleteEvent(theEvent); 
		 Persona thePers = personDAO.getPersonsId(theId);
			redirectAttrs.addFlashAttribute("some", thePers);
			return "redirect:/person/ShowPrimaryPage";  
	 }
	 
	 @GetMapping("/removeEvent")
	 public String removeEvent(Model theModel,@RequestParam("theId") int theId) {
		 
		//get person id session from the dao
			Persona thePers = personDAO.getPersonsId(theId);
			
			//add the person to the model
			 theModel.addAttribute("person",thePers);
			 
			 
			//get list event from DAO 
			List<Evento> events=eventDAO.getEvents();
			
			
			//add the list to the model  
			theModel.addAttribute("eventi",events);
		 
		 
			//get list event from DAO 
			List<Evento> evento=eventDAO.getEvents();
			theModel.addAttribute("eventone",evento);
			
			
		 return "primary-page";
	 }
	
}
