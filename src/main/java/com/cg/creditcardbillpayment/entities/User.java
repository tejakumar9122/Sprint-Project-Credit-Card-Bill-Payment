package com.cg.creditcardbillpayment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private String userId;
	private String password;
	private UserRole role;	
	private AuthenticationStatus authStatus;

	public User() {
		super();
	}

	public User(String userId, String password, UserRole role, AuthenticationStatus authStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.authStatus = authStatus;
	}

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public AuthenticationStatus getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(AuthenticationStatus authStatus) {
		this.authStatus = authStatus;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", authStatus=" + authStatus
				+ "]";
	}

	
}
