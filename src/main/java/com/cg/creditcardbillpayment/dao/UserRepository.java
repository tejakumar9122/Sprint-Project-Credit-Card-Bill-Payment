package com.cg.creditcardbillpayment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.creditcardbillpayment.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{




}
