package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.UserRepository;
import com.cg.creditcardbillpayment.dto.UserDto;
import com.cg.creditcardbillpayment.entities.AuthenticationStatus;
import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;

import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.exceptions.UserException;


/*******************************************************************************************************
 *         @author          B Sai Teja Kumar
 *         Description      It is a service class that provides the services to add a user,
 *          				remove a user, signin the user, signout the user and update the password
 *         Version          1.0
 *         Created Date    	24-March-2021
 *******************************************************************************************************/

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	/*******************************************************************************************
	 * Method: 						signIn
     * Description: 				To signIn to the user account
	 * @param user      			- user to check with the database
	 * @returns Boolean 			- true, if user signed in
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException 		- It is raised when the user password not matched,
	 								  user already signed in and user role not matched
     * Created By                   - B Sai Teja Kumar
     * Created Date                 - 24-March-2021                        
	 
	 ******************************************************************************************/

	@Override
	public Boolean signIn(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				if (!resultUser.get().getAuthStatus().equals(AuthenticationStatus.SIGNEDIN)) {
					if (resultUser.get().getRole().equals(user.getRole())) {
						status = true;
						resultUser.get().setAuthStatus(AuthenticationStatus.SIGNEDIN);
						User updatedUser = new User(resultUser.get().getUserId(), resultUser.get().getPassword(),
								resultUser.get().getRole(), resultUser.get().getAuthStatus());
						userRepository.save(updatedUser);
					} else {
						throw new UserException("Access denied");
					}
				} else {
					throw new UserException("User already signed in");
				}
			} else {
				throw new UserException("Wrong password");
			}
		} else {
			throw new NoSuchUserException("User not found");
		}
		return status;

	}

	/*********************************************************************************************************
	 * Method: 						signOut
     * Description: 				To signOut from the user account
	 * @param user      			- user to check with the database
	 * @returns Boolean 			- true, if user signed out
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException 		- It is raised when the user password not matched,user already signed out
     * Created By                   - B Sai Teja Kumar
     * Created Date                 - 24-March-2021                           
	 
	 *********************************************************************************************************/
	@Override
	public Boolean signOut(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				if (!resultUser.get().getAuthStatus().equals(AuthenticationStatus.SIGNEDOUT)) {
					status = true;
					resultUser.get().setAuthStatus(AuthenticationStatus.SIGNEDOUT);
					User updatedUser = new User(resultUser.get().getUserId(), resultUser.get().getPassword(),
							resultUser.get().getRole(), resultUser.get().getAuthStatus());
					userRepository.save(updatedUser);
				} else {
					throw new UserException("User already signed out");
				}
			} else {
				throw new UserException("Wrong password");
			}

		} else {
			throw new NoSuchUserException("User not found");
		}
		return status;
	}
	
	/*********************************************************************************************************
	 * Method: 						changePassword
     * Description: 				To update the password of the user 
     * @param id      				- id is to check with the database
	 * @param user      			- user to be updated with new password
	 * @returns User 				- returns user after updating the user password
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException 		- It is raised when the user old password not matched
     * Created By                   - B Sai Teja Kumar
     * Created Date                 - 24-March-2021                           
	 
	 *********************************************************************************************************/
	@Override
	public User changePassword(String id, UserDto user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		User changeUser;
		Optional<User> resultUser = userRepository.findById(id);
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getOldPassword())) {
				changeUser = new User(id, user.getNewPassword(), resultUser.get().getRole(),resultUser.get().getAuthStatus());
				userRepository.save(changeUser);
			} else {
				throw new UserException("Password Not Matched");
			}
		} else {
			throw new NoSuchUserException("User Not Found");
		}

		return changeUser;
	}
	/*********************************************************************************************************
	 * Method: 							addUser
     * Description: 					To add user to the database
	 * @param user      				- user to be added to the database
	 * @returns User 					- returns user after adding to the database
	 * @throws DuplicateUserException 	- It is raised when the user already exists in database
	 * Created By                   	- B Sai Teja Kumar
     * Created Date                 	- 24-March-2021                           
	 
	 *********************************************************************************************************/

	@Override
	public User addUser(User user) throws DuplicateUserException{
		// TODO Auto-generated method stub
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (resultUser.isEmpty()) {
			user.setAuthStatus(AuthenticationStatus.SIGNEDOUT);
			userRepository.saveAndFlush(user);
		} else {
			throw new DuplicateUserException("User Already Exists");
		}
		return user;
	}
	
	/*********************************************************************************************************
	 * Method: 							removeUser
     * Description: 					To remove user from the database
	 * @param id      					- id to be removed from the database
	 * @returns Boolean 				- true, if user has been removed
	 * @throws NoSuchUserException 		- It is raised when the user not exists in database
	 * Created By                   	- B Sai Teja Kumar
     * Created Date                 	- 24-March-2021                           
	 
	 *********************************************************************************************************/

	@Override
	public Boolean removeUser(String id) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = userRepository.findById(id);
		if (!resultUser.isEmpty()) {
			userRepository.deleteById(id);
			status = true;
		} else {
			throw new NoSuchUserException("User Not Found");
		}
		return status;
	}
	
	/*********************************************************************************************************
	 * Method: 							getAllUsers
     * Description: 					To get all the users from the database
	 * @returns User 					- returns users after fetching the database
	 * Created By                   	- B Sai Teja Kumar
     * Created Date                 	- 24-March-2021                           
	 
	 *********************************************************************************************************/

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
