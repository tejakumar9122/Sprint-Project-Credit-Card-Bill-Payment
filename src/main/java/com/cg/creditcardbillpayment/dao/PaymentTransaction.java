package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpayment.entities.Payment;

public interface PaymentTransaction extends JpaRepository<Payment,Long>{

}
