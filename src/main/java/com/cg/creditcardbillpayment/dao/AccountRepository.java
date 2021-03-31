package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpayment.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
