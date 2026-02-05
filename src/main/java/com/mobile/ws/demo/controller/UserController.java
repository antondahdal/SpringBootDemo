package com.mobile.ws.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.ws.demo.module.request.userDetailsRequestModel;
import com.mobile.ws.demo.module.response.UserRest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	Map<String, UserRest> users;

	@GetMapping(path = "/{userId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		System.out.println("Get user details for userId: " + userId);
		UserRest userRest =users.get(userId);;
		if(userRest != null) {
			return new ResponseEntity<UserRest>(userRest,HttpStatus.OK);
		}
	
		return new ResponseEntity<UserRest>(userRest,HttpStatus.NOT_FOUND);
	}

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		return "Users List +page 	" + page + " limit " + limit;
	}

	@PostMapping(
			consumes = { "application/json", "application/xml" },
			produces = { "application/json", "application/xml" })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody userDetailsRequestModel userDetails) {
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
		
		return new ResponseEntity<UserRest>(tempUserRest,HttpStatus.OK);
	}

	@PutMapping
	public String updateUser() {
		return "usersDetailsUpdated";
	}

	@DeleteMapping
	public String deleteUser() {
		return "usersDeleted";
	}

}