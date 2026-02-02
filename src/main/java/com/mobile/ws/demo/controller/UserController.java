package com.mobile.ws.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.ws.demo.module.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping(path = "/{userId}", produces = { "application/json", "application/xml" })
	public UserRest getUser(@PathVariable String userId) {
		System.out.println("Get user details for userId: " + userId);
		UserRest userRest = new UserRest();
		userRest.setFirstName("John");
		userRest.setLastName("Doe");
		userRest.setEmail("abcd@mail.com");
		userRest.setId(userId);
		return userRest;
	}

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		return "Users List +page 	" + page + " limit " + limit;
	}

	@PostMapping
	public String createUser() {
		return "usersCreated";
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
