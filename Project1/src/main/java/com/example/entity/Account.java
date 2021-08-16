package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts", schema = "accounts_db")
public class Account {

	@Id
	private String number;
	private double balance;
	
	public Account(String number, double balance) {
		super();
		this.number = number;
		this.balance = balance;
	}

	public Account() {

	}
	
	public String getAccNumber() {
		return number;
	}

	public void setAccNumber(String number) {
		this.number = number;
	}

	public double getAccountBalance() {
		return balance;
	}

	public void setAccountBalance(double accountBalance) {
		this.balance = accountBalance;
	}

	@Override
	public String toString() {
		return "Amount [number=" + number + ", accountBalance=" + balance + "]";
	}
	
}
