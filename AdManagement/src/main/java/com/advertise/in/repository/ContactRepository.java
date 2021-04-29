package com.advertise.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advertise.in.model.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer > {

}
