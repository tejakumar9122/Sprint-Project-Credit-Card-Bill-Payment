package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	private String refNo;
	private String status;
	private LocalDate Datee;
	private LocalTime time;
	private String cardNo;
	private String emailAddr;
	private String mobileNo;
	private Double paymentAmount;
	private String payFrom;

	public Transaction() {
		super();
	}

	public Transaction(String refNo, String status, LocalDate datee, LocalTime time, String cardNo, String emailAddr,
			String mobileNo, Double paymentAmount, String payFrom) {
		super();
		this.refNo = refNo;
		this.status = status;
		Datee = datee;
		this.time = time;
		this.cardNo = cardNo;
		this.emailAddr = emailAddr;
		this.mobileNo = mobileNo;
		this.paymentAmount = paymentAmount;
		this.payFrom = payFrom;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDatee() {
		return Datee;
	}

	public void setDatee(LocalDate datee) {
		Datee = datee;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPayFrom() {
		return payFrom;
	}

	public void setPayFrom(String payFrom) {
		this.payFrom = payFrom;
	}

	@Override
	public String toString() {
		return "Transaction [refNo=" + refNo + ", status=" + status + ", Datee=" + Datee + ", time=" + time
				+ ", cardNo=" + cardNo + ", emailAddr=" + emailAddr + ", mobileNo=" + mobileNo + ", paymentAmount="
				+ paymentAmount + ", payFrom=" + payFrom + "]";
	}
}
