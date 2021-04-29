package com.advertise.in.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.ErrorDetails;
import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.Advertise;
import com.advertise.in.model.Contact;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.service.AdvertiseService;
import com.advertise.in.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin
@RestController
@RequestMapping(value = "/advertise")
public class AdvertiseController {
	
//********************************Applied logger to AdvertiseController****************************
	Logger logger1=LoggerFactory.getLogger(RegisterUserEntity.class);
	Logger logger2=LoggerFactory.getLogger(Contact.class);
	Logger logger3=LoggerFactory.getLogger(Advertise.class);

	@Autowired
	private AdvertiseService advertService;
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private ContactService contactService;
	
	
	// create Advertise
	@ApiOperation(value="Insert new Advertisement", response= Advertise.class)
	@PostMapping(value ="/register")
	public Advertise createEmployee(@RequestBody Advertise advertise) {
		
			logger3.info("created advertise successfully");
			return advertService.addAdvertise(advertise);
	}
	
	
	//
	@ApiOperation(value = "update Advertisement Details", response = Advertise.class)
	@PutMapping("/{eid}")
	public ResponseEntity<Advertise> updateOrSaveAdvertise(@RequestBody Advertise advertise,
			@PathVariable Integer eid) {
		if (advertiseRepository.findById(advertise.getEid()).isPresent()) {
			Advertise e = advertService.updateOrSaveAdvertise(advertise, eid);
			return new ResponseEntity<Advertise>(e, HttpStatus.OK);
		} else {
			new ResourceNotFoundException("Employee not exist with id :" + eid);
			return new ResponseEntity<Advertise>(advertise, HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Fetch all advertisements", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "SUCCESS",response = Advertise.class),
			@ApiResponse(code = 401,message = "UNAUTHORIZED!",response = ErrorDetails.class),
			@ApiResponse(code = 403,message = "FORBIDDEN!",response = ErrorDetails.class),
			@ApiResponse(code = 484,message = "NOT FOUND",response = ErrorDetails.class)
	})
	
	@GetMapping(value="/viewAdvertisements")
	public ResponseEntity<List<Advertise>> viewProducts()
	{
		List<Advertise> advertisement=advertService.getAllAdvertisements();
		logger3.info("list of all advertisements");
		logger3.info("Advertisement List");
		return new ResponseEntity<List<Advertise>>(advertisement,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Fetch Advertisement by Id", response = Advertise.class)
	@GetMapping("/viewAdvertisements/{eid}")
	public ResponseEntity<Advertise> getAdvertisementById(@PathVariable Integer eid) {
		
		Advertise product = advertService.getById(eid).orElseThrow(() -> new ResourceNotFoundException("Advertisement not found with the given id"+eid));
		logger3.info("view advertisement by id"+eid);
		return ResponseEntity.ok(product);
	}
	
	@ApiOperation(value = "Delete an Advertisement",response = Advertise.class)
	@DeleteMapping(value="/viewAdvertisements/{eid}")
    public ResponseEntity<String>deleteAdvertisementsById(@PathVariable Integer eid) {

   List<Advertise> advertisement=advertService.getAllAdvertisements();

      advertService.deleteAdvertisementsById(eid);
      logger3.info("delete an advertisement by id"+eid);
      return new ResponseEntity<String>("Delete With ID : " + eid + "Deleted", HttpStatus.OK);
      
   }

	//***********************************************************************************************
	//********************************view all customers*********************************************
	
	@ApiOperation(value = "Fetch all Customers", response = Iterable.class)
	@GetMapping(value="/viewCustomers")
	public ResponseEntity<List<RegisterUserEntity>> viewCustomers()
	{
		List<RegisterUserEntity> customers=advertService.getAllCustomers();
		logger1.warn("please check carefully!!!!");
		logger1.info("inside class!!!! AdvertiseController, method!!!: viewCustomers");
		logger1.info("list of all customers registered to the website");
		logger1.info("Happy Customers!");
		return new ResponseEntity<List<RegisterUserEntity>>(customers,HttpStatus.OK);
	}
	
	
	//********************************view all issues************************************************
	
	@ApiOperation(value = "Fetch all Issues", response = Iterable.class)
	@GetMapping(value="/viewIssues")
	public ResponseEntity<List<Contact>> viewDetails()
	{
		List<Contact> details=advertService.getIssues();
		logger2.warn("please check carefully!!!!");
		logger2.info("inside class!!!! AdvertiseController, method!!!: viewDetails");
		logger2.info("list of all customer issues related to website");
		logger2.info("Customer Issues");
		return new ResponseEntity<List<Contact>>(details,HttpStatus.OK);
	}
	
	
	//******************************* delete customer issue if solved ********************************
	
	@ApiOperation(value = "Delete customer issue if resolved",response = Contact.class)
	@DeleteMapping(value="/viewIssues/{contactId}")
    public ResponseEntity<String> deleteIssueById(@PathVariable Integer contactId) {

   List<Contact> issue=advertService.getIssues();

      advertService.deleteContactIssueById(contactId);
      logger3.info("delete customer issue by id"+contactId);
      return new ResponseEntity<String>("Delete With ID : " + contactId, HttpStatus.OK);
      
   }

	
}
