package com.example.exceptionhandler;

public class AccountNotFoundException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
 public String getMessage() {
	 return "Enter valid Account Number:";
 }
}
