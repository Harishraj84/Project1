package com.example.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Txn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private Date date;
	private TxnType CreditOrDebit;
	private double amount;
	private String account;
	
	public Txn(String account, Date date, double amount, TxnType CreditOrDebit) {
		super();
		this.account = account;
		this.date = date;
		this.amount = amount;
		this.CreditOrDebit = CreditOrDebit;
	}
	
	public Txn() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxnType getCreditOrDebit() {
		return CreditOrDebit;
	}

	public void setCreditOrDebit(TxnType creditOrDebit) {
		this.CreditOrDebit = creditOrDebit;
	}

	@Override
	public String toString() {
		return "TransactionId = " + transactionId + ", Account Number = " + account+ ", date = " + date + ", amount = " + amount
				+ ", creditOrDebit = " + CreditOrDebit;
	}
	
}
