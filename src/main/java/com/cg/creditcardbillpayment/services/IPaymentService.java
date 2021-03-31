package com.cg.creditcardbillpayment.services;

import com.cg.creditcardbillpayment.entities.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment removePayment(long id);

	public Payment updatePayment(long id, Payment payment);

	public Payment getPayment(long id);
}
