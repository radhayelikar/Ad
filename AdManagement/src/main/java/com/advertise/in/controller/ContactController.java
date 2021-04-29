package com.advertise.in.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.InputException;
import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.Contact;
import com.advertise.in.service.ContactService;

@CrossOrigin
@RestController
@RequestMapping(value="/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	
	//********************* Applied logger to the ContactController *********************************************
	Logger logger=LoggerFactory.getLogger(Contact.class);
	
	//**************************************** create contact details ********************************************
	@PostMapping(value="/user",produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNewUser(@RequestBody Contact details)
	{
		try {
		contactService.createContact(details);
		logger.info("Logging services started");
		logger.info("inside class!!!! ContactController, method!!!: addNewUser");
		logger.info("created customer query successfully");
	    return new ResponseEntity<String>("created Successfully ",HttpStatus.OK);
		}
		catch(DataIntegrityViolationException e)
		{
			logger.error("the input is invalid");
			throw new InputException("The input is not valid");
		}
		
	}

}
