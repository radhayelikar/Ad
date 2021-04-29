package com.advertise.in.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "DetailsTable")
public class Advertise {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	
	@NotNull
	private String adTitle;

	
	@NotNull
	private String adType;

	
	@NotNull
	private String description;

	
	@JsonFormat(pattern = "dd-MM-YYYY")
	private String bookingDate;

	
	@JsonFormat(pattern = "dd-MM-YYYY")
	private String expiryDate;

	
	@NotNull
	@Size(min = 2, max = 50, message = "Address length should be greater than 2")
	@Pattern(regexp = "[A-Za-z]+", message = "Please Enter Valid Address")
	private String address;

	
	@NotNull
	@Size(min = 10, max = 10, message = "Please Enter Valid Phone Number of length 10 digits")
	@Pattern(regexp = "[0-9]+")
	private String phoneNo;

	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+[ ]?[A-za-z]*[ ]?[A-za-z]*", message = "Please Enter Valid Company Name")
	private String companyName;

	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+", message = "Please Enter Valid Email-ID")
	private String email;

	
	@NotNull
	@Size(min = 4, max = 9, message = "Please Enter Valid Amount")
	@Pattern(regexp = "[0-9]+")
	private String amount;
	
	@Column(name = "ad_detail1")
	private String detail1 ;
	
	@Column(name = "ad_detail2")
	private String detail2 ;
	
	@Column(name = "ad_detail3")
	private String detail3 ;
	
	@Size(min=10, max = 1000)
	@Column(name = "picture_1")
	private String picture1 ;
	
	@Size(min=10, max = 1000)
	@Column(name = "picture_2")
	private String picture2 ;
	
    @Size(min=10, max = 1000)
	@Column(name = "picture_3")
	private String picture3 ;
	
	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public String getDetail3() {
		return detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}

	
	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Advertise(Integer eid, @NotNull String adTitle, @NotNull String adType, @NotNull String description,
			String bookingDate, String expiryDate,
			//@NotNull @Size(min = 2, max = 50, message = "Address length should be greater than 2")
			@Pattern(regexp = "[A-Za-z]+", message = "Please Enter Valid Address") String address,
			//@NotNull @Size(min = 10, max = 10, message = "Please Enter Valid Phone Number of length 10 digits") 
			@Pattern(regexp = "[0-9]+") String phoneNo,
			@NotNull @Pattern(regexp = "[A-Za-z]+[ ]?[A-za-z]*[ ]?[A-za-z]*", message = "Please Enter Valid Company Name") String companyName,
			@NotNull @Pattern(regexp = "[A-Za-z]+[0-9]*@[a-zA-Z]+.[a-zA-A]+", message = "Please Enter Valid Email-ID") String email,
			//@NotNull @Size(min = 4, max = 9, message = "Please Enter Valid Amount")
			@Pattern(regexp = "[0-9]+") String amount,
			String detail1, String detail2, String detail3,
			@Size(min = 1, max = 1000) String picture1,
			@Size(min = 1, max = 1000) String picture2,
			@Size(min = 1, max = 1000) String picture3)
{
		super();
		this.eid = eid;
		this.adTitle = adTitle;
		this.adType = adType;
		this.description = description;
		this.bookingDate = bookingDate;
		this.expiryDate = expiryDate;
		this.address = address;
		this.phoneNo = phoneNo;
		this.companyName = companyName;
		this.email = email;
		this.amount = amount;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.picture1 = picture1;
		this.picture2 = picture2;
		this.picture3 = picture3;
	}
	



	

	

}
