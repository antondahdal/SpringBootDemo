package com.mobile.ws.demo.exceptions;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = {Exception .class})
	public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request) {
		System.out.println("HERE");
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
