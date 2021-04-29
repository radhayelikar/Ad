package com.advertise.in.service;

import com.advertise.in.model.Admin;

public interface IAdminService {

	public String getAdmin(String email,String password);
	public Admin updateAdminPassword(String email,Admin admin);
	
}
