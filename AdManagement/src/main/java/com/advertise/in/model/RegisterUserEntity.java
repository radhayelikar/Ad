package com.advertise.in.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customer")
public class RegisterUserEntity {

	@Id
	@GeneratedValue
	@Column(name="application_id")
	private int application_id;
	
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;

	
	@Column(name="email_id")
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+$",message = "enter email in valid format")
	private String emailId;
	
	@Column(name="password", nullable = false)
	private String password;

	
	@Column(name="gender")
	private String gender;
	
	@Column(name="mobile_number")
	private String mobile_number;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	

	

	public RegisterUserEntity() {
		super();
	}




	public RegisterUserEntity(int application_id, String fname, String lname,String emailId,String password, String gender,
			String mobile_number, String address, String city) {
		super();
		this.application_id = application_id;
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.password=password;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.address = address;
		this.city = city;
		
	}
	

	public RegisterUserEntity(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}


	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public String getFname() {
		return fname;
	}

	



	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}




	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getGender() {
		return gender;
	}
	
	


	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	@Override
	public String toString() {
		return "RegisterUserEntity [application_id=" + application_id + ", fname=" + fname + ",lname=" + lname + ", emailId="
				+ emailId + ", password=" + password + ", gender=" + gender + ", mobile_number=" + mobile_number
				+ ", address=" + address + ", district=" + city + "]";
	}

	
}
	
