package com.cg.creditcardbillpayment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	private Long paymentId;
	private String type;
	private String status;
	@OneToOne
	private CreditCard card;

	public Payment() {
		super();
	}

	public Payment(Long paymentId, String type, String status, CreditCard card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}
}
