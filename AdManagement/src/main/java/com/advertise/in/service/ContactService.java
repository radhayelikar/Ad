package com.advertise.in.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertise.in.model.Contact;
import com.advertise.in.repository.ContactRepository;

@Service
public class ContactService {

	//***********************Applied logger to the ContactSevice *********************************
	Logger logger=LoggerFactory.getLogger(Contact.class);
	@Autowired
	private ContactRepository contactRepo;
	
	//****************************** create contact details***************************************
	 public Contact createContact(Contact details) {
         // TODO Auto-generated method stub
		 logger.info("inside class!!!! ContactServicve, method!!!: createContact");
	       return contactRepo.save(details);
	 }
	 
}
