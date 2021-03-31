package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpayment.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,String>{

}
