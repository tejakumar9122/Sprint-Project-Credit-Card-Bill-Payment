package com.cg.creditcardbillpayment.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpayment.dto.UserDto;
import com.cg.creditcardbillpayment.entities.AuthenticationStatus;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.entities.UserRole;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.exceptions.UserException;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private IUserService userService;
	User signoutUser=new User("CG101","101password",UserRole.CUSTOMER,AuthenticationStatus.SIGNEDIN);
	User signinUser=new User("CG102","102password",UserRole.CUSTOMER,AuthenticationStatus.SIGNEDOUT);
	User exceptionUser=new User("0905","password",UserRole.CUSTOMER,AuthenticationStatus.SIGNEDOUT);
				
	
	
	@Test
	void testSignIn1() throws NoSuchUserException {		
		assertTrue(userService.signIn(signinUser));
	}
	

	@Test
	void testSignIn2() {	
		assertThrows(NoSuchUserException.class,()->userService.signIn(exceptionUser));
	}
	
	
	@Test
	void testSignOut1() throws NoSuchUserException {
		assertTrue(userService.signOut(signoutUser));
	}
	
	@Test
	void testSignOut3() {	
		assertThrows(NoSuchUserException.class,()->userService.signIn(exceptionUser));
	}
	
	@Test
	void testChangePassword1() throws NoSuchUserException {
		UserDto data=new UserDto("CG103","password","103password");
		User updatedUser=userService.changePassword(data.getUserId(),data);
		assertEquals("103password",updatedUser.getPassword());
	}
	
	@Test
	void testChangePassword2() throws NoSuchUserException {
		UserDto data=new UserDto("CG103","password","103password");
		User updatedUser=userService.changePassword(data.getUserId(),data);
		assertNotEquals("password",updatedUser.getPassword());
	}
	@Test
	void testChangePassword3() {		
		UserDto data=new UserDto("CG103","passord","103password");
		assertThrows(UserException.class,()->userService.changePassword(data.getUserId(),data));
	}
	

	
}
