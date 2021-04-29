package com.advertise.in.controller;



import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.advertise.in.model.Contact;
import com.advertise.in.repository.ContactRepository;
import com.advertise.in.service.AdminServiceImpl;
import com.advertise.in.service.AdvertiseService;
import com.advertise.in.service.ContactService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ContactControllerTest {

	private static final ObjectMapper om =new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactService contactService;
	
	@MockBean
	private AdvertiseService advertiseService;
	
	@MockBean
	private ContactRepository contactRepository;
	
	
	//***************************************** test for get all queries **************************************
	@Test
	public void viewAllQueries_OK() throws Exception{
		List<Contact> contact=new ArrayList<>();
		contact.add(new Contact(1,"shruti123@gmail.com","Shruti Gupta","7558510110","I have query related to update"));
		contact.add(new Contact(2,"simran321@gmail.com","Simran Gupta","9325296173","I have query related to update"));
		when(advertiseService.getIssues()).thenReturn(contact);
		String url="/advertise/viewIssues";
		
		mockMvc.perform(get(url)).andExpect(status().isOk());
		
	}
}
