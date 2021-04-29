package com.advertise.in.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.advertise.in.model.Advertise;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.AdvertiseRepository;
import com.advertise.in.service.AdvertiseService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AdvertiseControllerTest {

	
	@Autowired
	 private MockMvc mockMvc;
	
	@MockBean
	private AdvertiseService advertService;
	
	@MockBean
	private AdvertiseRepository advertRepo;
	
	@Test
	public void viewAllAdvertisements_OK() throws Exception{
		
		List<Advertise> advertise= new ArrayList<>();
		advertise.add(new Advertise(1,"CarGo","Travels","Lets Go.","28-01-21","30-01-21", "Pune","9373893345","TATA","cargo456@gmail.com","8000","a/c","image1","non a/c","image2","double decker","image3"));
		advertise.add(new Advertise(2,"Samsung S20","Smartphone","Future is bright","12-04-21","14-04-21","Nagpur","8965674687","Samsung","samsung@gmail.com","65000","samsung S20","picture1","samsung A7","picture2","samsung A20","picture3"));
		when(advertService.getAllAdvertisements()).thenReturn(advertise);
		String url="/advertise/viewAdvertisements";
		
		mockMvc.perform(get(url)).andExpect(status().isOk());
}
	
	//**************************** Test for view customers ********************************************
	@Test
	public void viewAllCustomers_OK() throws Exception{
		
		List<RegisterUserEntity> customers=new ArrayList<>();
		customers.add(new RegisterUserEntity(1,"Shruti","Gupta","guptashruti@gmail.com","Shruti@123","female","9364747836","Dongri Mines","Nagpur"));
		customers.add(new RegisterUserEntity(2,"Simran","Gupta","guptasimran@gmail.com","Simran@123","female","9364747870","Gandhi Chowk","Nagpur"));
		when(advertService.getAllCustomers()).thenReturn(customers);
		String url="/advertise/viewCustomers";
		
		mockMvc.perform(get(url)).andExpect(status().isOk());
	}
	
		
}
