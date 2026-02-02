package com.mobile.ws.demo.module.request;

public class userDetailsRequestModel {
    private String email;
    private String firstName;
    private String password;
    private String lastName;
 
    
    public userDetailsRequestModel() {
    	
    }
public userDetailsRequestModel(userDetailsRequestModel userDetails) {
	this.email = userDetails.getEmail();
	this.firstName = userDetails.getFirstName();
	this.password = userDetails.getId();
	this.lastName = userDetails.getLastName();
}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return password;
    }

    public void setId(String id) {
        this.password = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}