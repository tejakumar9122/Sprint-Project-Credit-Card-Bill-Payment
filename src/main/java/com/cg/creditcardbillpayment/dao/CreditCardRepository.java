package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpayment.entities.CreditCard;



public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{

}
