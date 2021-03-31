package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;

import com.cg.creditcardbillpayment.exceptions.UserException;


@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<String> userException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<String> noUserException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<String> existedUserException(Exception exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.CONFLICT);
	}
}
