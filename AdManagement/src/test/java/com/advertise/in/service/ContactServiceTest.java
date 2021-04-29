package com.advertise.in.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.advertise.in.model.Contact;
import com.advertise.in.repository.ContactRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactServiceTest {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AdvertiseService advertiseService;
	
	@MockBean
	private ContactRepository contactRepo;
	
	//*********************************** test for create contact us *********************************
	@Test
	public void testSaveContact() {
	Contact contact1=new Contact(1,"guptashruti806@gmail.com","Shruti Gupta","7558510110","Smartphone related query");
	when(contactRepo.save(contact1)).thenReturn(contact1);
	
	Contact contact2=contactService.createContact(contact1);
	assertEquals(contact1,contact2);
	}
	
	
	//********************************** test for get all customer issues ********************************
	@Test
	@DisplayName("view all customer issues")
	public void getAllContactUs() {
		when(contactRepo.findAll()).thenReturn(Stream.of(new Contact(1,"guptashruti806@gmail.com","Shruti Gupta","9325296173","I have query related to update profile"),
				                                         new Contact(2,"simran123@gmail.com","Simran Gupta","9364748845","Smartphone issue"))
				.collect(Collectors.toList()));
		List<Contact> contacts=advertiseService.getIssues();
		assertEquals(2,contacts.size());
	}
}
