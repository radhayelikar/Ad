package com.advertise.in.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.advertise.in.model.Contact;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ContactRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@BeforeEach
	
	void setUp() throws Exception{
		entityManager.persist(new Contact(1, "shruti123@gmail.com","Shruti Gupta","7558510110","Update profile issue"));
		entityManager.persist(new Contact(2, "mansi567@gmail.com","Mansi Mandhare","9462829383","Update profile issue"));
		
	}
}
