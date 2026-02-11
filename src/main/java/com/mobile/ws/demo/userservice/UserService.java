package com.mobile.ws.demo.userservice;

import com.mobile.ws.demo.module.request.userDetailsRequestModel;
import com.mobile.ws.demo.module.response.UserRest;

public interface UserService {
	UserRest creatteUser(userDetailsRequestModel userDetails);

}
