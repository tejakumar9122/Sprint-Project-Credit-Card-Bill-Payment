package com.cg.creditcardbillpayment.exceptions;

public class DuplicateUserException extends RuntimeException{

	public DuplicateUserException(String message) {
		super(message);
	}
}
