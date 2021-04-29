package com.advertise.in.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.Advertise;
import com.advertise.in.model.Contact;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.repository.ContactRepository;
import com.advertise.in.repository.RegisterUserRepo;

@Service
public class AdvertiseService {

	//************************* Applied logger to AdvertiseService *******************************
	Logger logger1=LoggerFactory.getLogger(RegisterUserEntity.class);
	Logger logger2=LoggerFactory.getLogger(Contact.class);
	Logger logger3=LoggerFactory.getLogger(Advertise.class);
	
	@Autowired
	private AdvertiseRepository advertRepo;
	
	@Autowired
	private RegisterUserRepo userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	// creating new advertise
		public Advertise addAdvertise(Advertise advertise) {
			return advertRepo.save(advertise);
		}

	// get All Advertisements
	public List<Advertise> getAllAdvertisements()
	{
		List<Advertise> product=(List<Advertise>)advertRepo.findAll();
		return product;
	}
	
	public Optional<Advertise> getById(Integer eid) {
		
		Optional<Advertise> product=advertRepo.findById(eid);
		return product;
		
	}
	
	public Advertise updateOrSaveAdvertise(Advertise updateAd, Integer eid) {
		return advertRepo.findById(eid).map(advertise -> {
			advertise.setAdTitle(updateAd.getAdTitle());
			advertise.setAdType(updateAd.getAdType());
			advertise.setDescription(updateAd.getDescription());
			advertise.setBookingDate(updateAd.getBookingDate());
			advertise.setExpiryDate(updateAd.getExpiryDate());
			advertise.setAddress(updateAd.getAddress());
			advertise.setPhoneNo(updateAd.getEmail());
			advertise.setCompanyName(updateAd.getCompanyName());
			advertise.setEmail(updateAd.getEmail());
			advertise.setAmount(updateAd.getAmount());

			return advertRepo.save(updateAd);
		}).orElseGet(() -> {
			return advertRepo.save(updateAd);
		});
	}
	
	
	public void deleteAdvertisementsById(Integer eid) {
		
		advertRepo.findById(eid).
		orElseThrow(()->new ResourceNotFoundException("Resume with ID"+eid+" is not available. Please enter correct ID :("));	
	    advertRepo.deleteById(eid);
	}
	
	
	//****************************** get all customer business logic*************************************
	public List<RegisterUserEntity> getAllCustomers()
	{
		logger3.info("inside class!!!! AdvertiseService, method!!!: getAllCustomers");
		List<RegisterUserEntity> customer=(List<RegisterUserEntity>)userRepo.findAll();
		return customer;
	}
	
	
	//**************************** get all Customer issues ***********************************************
	public List<Contact> getIssues()
	{
		logger2.info("inside class!!!! AdvertiseService, method!!!: getIssues");
		List<Contact> details=(List<Contact>)contactRepo.findAll();
		return details;
	}
	
	
	//**************************** delete customer issue *************************************************
	public void deleteContactIssueById(Integer contactId) {
		contactRepo.findById(contactId).
		orElseThrow(()-> new ResourceNotFoundException("Resume with ID"+contactId+" is not available. Please enter correct ID :("));
		contactRepo.deleteById(contactId);
	}
}
