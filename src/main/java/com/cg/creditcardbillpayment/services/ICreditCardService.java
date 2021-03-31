package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.CreditCard;

public interface ICreditCardService {
	public CreditCard addCreditCard(CreditCard creditCard);

	public CreditCard removeCreditCard(long cardId);

	public CreditCard updateCreditCard(long cardId, CreditCard card);

	public CreditCard getCreditCard(long cardId);

	public List<CreditCard> getAllCreditCards();

}
