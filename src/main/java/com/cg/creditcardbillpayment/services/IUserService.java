package com.cg.creditcardbillpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dto.UserDto;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;


@Service
public interface IUserService {
	
	public Boolean signIn(User user) throws NoSuchUserException;
	public Boolean signOut(User user) throws NoSuchUserException;
	public User changePassword(String id, UserDto user) throws NoSuchUserException;	
	
	public User addUser(User user) throws DuplicateUserException;
	public Boolean removeUser(String id) throws NoSuchUserException; 
	public List<User> getAllUsers();
	
	
	
}
