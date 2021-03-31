package com.cg.creditcardbillpayment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private Long accountNumber;
	private String accountName;
	private double balance;
	private String type;

	public Account() {
		super();
	}

	public Account(Long accountNumber, String accountName, double balance, String type) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.type = type;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", type=" + type + "]";
	}
}
