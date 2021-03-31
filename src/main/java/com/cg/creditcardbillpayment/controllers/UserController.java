package com.cg.creditcardbillpayment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardbillpayment.dto.UserDto;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.services.IUserService;

import io.swagger.annotations.Api;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	/************************************************************************************
	 * Method                           : loginUser 
	 * Description                      : To login the user 
	 * @param User                 		- user is checked with the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Boolean                 - returns true, if user login successfully
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/

	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user) throws NoSuchUserException {
		return new ResponseEntity<Boolean>(userService.signIn(user), HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method                           : logoutUser 
	 * Description                      : To loginout the user 
	 * @param User                 		- user is checked with the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Boolean                 - returns true, if user logout successfully
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user) throws NoSuchUserException {
		return new ResponseEntity<Boolean>(userService.signOut(user), HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method                           : updatePassword 
	 * Description                      : To update the password of the user 
	 * @param User                 		- user password is to be updated in database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns User                 	- returns user after updating the user password to database 
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	
	@PutMapping("/updatepassword")
	public ResponseEntity<User> updatePassword(@RequestBody UserDto user) throws NoSuchUserException {
		return new ResponseEntity<User>(userService.changePassword(user.getUserId(), user), HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method                           : addUser 
	 * Description                      : To add the user to the database
	 * @param User                 		- user to be added to the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 *@returns User                 	- returns user after adding the user to database 
	 * @throws DuplicateUserException	- It is raised when user already exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws DuplicateUserException{
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}
	
	/************************************************************************************
	 * Method                           : removeUser 
	 * Description                      : To remove the user 
	 * @param id                 		- user with id is to be removed from the database
	 * @param PathVariable              - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Boolean                 - returns true, if user removed successfully
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	@PostMapping("/removeuser/{id}")
	public ResponseEntity<Boolean> removeUser(@PathVariable String id) throws NoSuchUserException {
		return new ResponseEntity<Boolean>(userService.removeUser(id), HttpStatus.OK);
	}
	
	
	/************************************************************************************
	 * Method                           : getAllUsers
	 * Description                      : To get all the users from the database
	 * @returns List<User>          	- returns users after fetching the database 
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************/
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

}
