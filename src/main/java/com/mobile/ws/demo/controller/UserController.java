package com.mobile.ws.demo.controller;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mobile.ws.demo.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(path = "/{userId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		System.out.println("Get user details for userId: " + userId);
		UserRest userRest = new UserRest();
		userRest.setFirstName("John");
		userRest.setLastName("Doe");
		userRest.setEmail("abcd@mail.com");
		userRest.setId(userId);
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
	public ResponseEntity<UserRest> createUser(@RequestBody userDetailsRequestModel userDetails) {
		UserRest retVal= userService.creatteUser(userDetails) ;
		System.out.println("First Name: " + userDetails.getFirstName());
		return new ResponseEntity<>(retVal,HttpStatus.OK);
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
