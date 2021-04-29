package com.advertise.in.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.postgresql.util.LruCache.CreateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.advertise.in.model.Advertise;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.repository.RegisterUserRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdvertiseServiceTest {

	@Autowired
	private AdvertiseService advertService;
	
	@MockBean
	private AdvertiseRepository advertRepo;
	
	@MockBean
	private RegisterUserRepo userRepo;
	
	@Test
	@DisplayName("view all advertisements")
	public void getAllAdvertisementsTest() {
		when(advertRepo.findAll()).thenReturn(Stream.of(new Advertise(1,"CarGo","Travels","Let's Go.","28-01-21","30-01-21","Nagpur","9325296173","TATA","cargo321@gmail.com","7000","a/c","image1","non a/c","image2","double decker","image3"),
				                                        new Advertise(2,"Samsung J5","Smartphone","Future is ahead","28-01-21","28-01-21","Pune","7558510110","Samsung","samsung@gmail.com","20000","samsung S20","picture1","samsung A7","picture2","samsung A20","picture3"))
				                                        .collect(Collectors.toList()));
		List<Advertise> advertise=advertService.getAllAdvertisements();
		assertEquals(2,advertise.size());
		
	}
	
	@Test
	@DisplayName("view advertisement by id")
	public void getAdvertisementByIdTest() {
		
		Advertise advertise= new Advertise(1,"CarGo","Travels","Let's Go.","28-01-21","30-01-21","Nagpur","9325296173", "TATA", "cargo321@gmail.com", "7000","a/c","image1","non a/c","image2","double decker","image3");
		when(advertRepo.findById(1)).thenReturn(Optional.of(advertise));
		assertThat(advertService.getById(2)).isNotEqualTo(advertise);
	}
	
	
	// ******************************  Test for view all customers **************************************
	@Test
	@DisplayName("view all customers")
	public void getAllCustomersTest() {
		when(userRepo.findAll()).thenReturn(Stream.of(new RegisterUserEntity(1,"Shruti","Gupta","guptashruti@gmail.com","Shruti@123","female","9364747836","Dongri Mines","Nagpur"),
				                                      new RegisterUserEntity(2,"Simran","Gupta","guptasimran@gmail.com","Simran@123","female","9364747870","Gandhi Chowk","Nagpur"))
				                                      .collect(Collectors.toList()));
		List<RegisterUserEntity> customers=advertService.getAllCustomers();
		assertEquals(2,customers.size());
	}
	
}
