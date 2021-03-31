package com.cg.creditcardbillpayment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpayment.entities.Address;

public interface AddressRepository extends JpaRepository<Address,String>{

}
