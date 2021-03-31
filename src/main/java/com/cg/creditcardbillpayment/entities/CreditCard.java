package com.cg.creditcardbillpayment.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard {
	@Id
	private Long cardId;
	private String bankName;
	private String cardType;
	private String cardName;
	private String cardNumber;
	private LocalDate cardExpiry;
	private int cvv;

	public CreditCard() {
		super();
	}

	public CreditCard(Long cardId, String bankName, String cardType, String cardName, String cardNumber,
			LocalDate cardExpiry, int cvv) {
		super();
		this.cardId = cardId;
		this.bankName = bankName;
		this.cardType = cardType;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [cardId=" + cardId + ", bankName=" + bankName + ", cardType=" + cardType + ", cardName="
				+ cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry + ", cvv=" + cvv + "]";
	}
}
