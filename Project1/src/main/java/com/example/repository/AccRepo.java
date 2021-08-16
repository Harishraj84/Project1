package com.example.repository;

public interface AccRepo {

	boolean transfer(String account);
	
	double balance(String account);

	void update(String accountNumber, double balance);
	
}
