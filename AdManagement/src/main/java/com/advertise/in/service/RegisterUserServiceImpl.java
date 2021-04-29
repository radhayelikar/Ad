package com.advertise.in.service;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.advertise.in.exception.ResourceNotFoundException;
import com.advertise.in.model.RegisterUserEntity;
import com.advertise.in.repository.RegisterUserRepo;


@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	
		static String emailIdLogin;

        @Autowired
        private RegisterUserRepo resgisterUserrepo;

     public RegisterUserEntity createRegisterUserEntity(RegisterUserEntity registerUser) {
              // TODO Auto-generated method stub
    	 return resgisterUserrepo.save(registerUser);
    	 }
     
     
     public String UserLogin(String emailId, String password)
 	{
    	 
        emailIdLogin =emailId;
// 		RegisterUserEntity user=resgisterUserrepo.findByEmailId(emailId);
 		Boolean customer_found= false;
 		List<RegisterUserEntity> customer=(List<RegisterUserEntity>) resgisterUserrepo.findAll();
 		for(RegisterUserEntity c:customer)
 		{
 			if(c.getEmailId().equals(emailIdLogin) && c.getPassword().equals(password))
 			{
 				customer_found=true;
 				System.out.println("Login Successfully..  :)");
 				return emailIdLogin;
 			}
 		}
 		if(customer_found==false)
 		{
 			System.out.println("Login Fail...If you are new user do register first");
 		}
 		return emailIdLogin;
 	}
     
     public RegisterUserEntity updateUser(Map<String,String> updateData)
 	{
 		RegisterUserEntity user = new RegisterUserEntity();
 		String emailId=emailIdLogin;
 		String updatedPassword=updateData.get("password");
 		String updatedAddress=updateData.get("address");
 		String updatedCity=updateData.get("city");
 		String updatedMobile_number=updateData.get("mobile_number");
 		if(emailId==null)
 		{
 			throw new ResourceNotFoundException("Please Enter Pancard Number"); 
 		}
 		try
 		{
 			user=resgisterUserrepo.findByEmailId(emailId);
 			if(!StringUtils.isEmpty(updatedPassword))
 			{
 				user.setPassword(updatedPassword);
 			}
 			if(!StringUtils.isEmpty(updatedAddress))
 			{
 				user.setAddress(updatedAddress);
 			}
 			if(!StringUtils.isEmpty(updatedCity))
 			{
 				user.setCity(updatedCity);
 			}
 			if(!StringUtils.isEmpty(updatedMobile_number))
 			{
 				user.setMobile_number(updatedMobile_number);
 			}
 			resgisterUserrepo.save(user);
 		}
 		catch(Exception ex)
 		{
 			throw new ResourceNotFoundException("Email Number not Found.....Please Enter valid Pancard Number.....");
 		}
 		return user;
 	}
     
     

}