package com.advertise.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.in.exception.AdminNotFoundException;
import com.advertise.in.model.Admin;
import com.advertise.in.service.IAdminService;



@CrossOrigin
@RestController
@RequestMapping(value="/login")
public class AdminController {

	@Autowired(required=true)
	public IAdminService adminservice;
	
	
	
	@GetMapping(value="/admin/{email}/{password}")
	public ResponseEntity<String>getAdmin(@PathVariable String email,@PathVariable String password)throws AdminNotFoundException{
		
		String message=adminservice.getAdmin(email,password);
		
		return new ResponseEntity<>(message,HttpStatus.OK);
	
}	
	
	@PatchMapping(value="/adminresetpassword/{email}")
	public ResponseEntity<Admin>updateAdminPassword(@PathVariable String email,
			@RequestBody Admin newadmin)
	{
		return new ResponseEntity<>(adminservice.updateAdminPassword(email, newadmin),HttpStatus.OK);
		
	}
	
}
