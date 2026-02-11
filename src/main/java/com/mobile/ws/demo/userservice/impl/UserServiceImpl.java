package com.mobile.ws.demo.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import org.springframework.stereotype.Service;

import com.mobile.ws.demo.module.request.userDetailsRequestModel;
import com.mobile.ws.demo.module.response.UserRest;
import com.mobile.ws.demo.userservice.UserService;
 

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;

	@Override
	public UserRest creatteUser(userDetailsRequestModel userDetails) {
	if(users == null) users = new HashMap<>();
		
		UserRest tempUserRest = new UserRest();
		String ID= UUID.randomUUID().toString();
		tempUserRest.setFirstName(userDetails.getFirstName());
		tempUserRest.setLastName(userDetails.getLastName());
		tempUserRest.setEmail(userDetails.getEmail());
		tempUserRest.setId(ID);
		
		if(!users.containsKey(userDetails.getId())) {
			users.put(ID, tempUserRest) ;
		}
		System.out.println();
		System.out.println("First Name: " + userDetails.getFirstName());
		
		return tempUserRest;}

}
