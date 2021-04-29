package com.advertise.in.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@NotEmpty(message="plz enter email :")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+$",message = "enter email in valid format")
	private String email;
	
	
	@NotEmpty(message="plz enter password :")
	private String password;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
