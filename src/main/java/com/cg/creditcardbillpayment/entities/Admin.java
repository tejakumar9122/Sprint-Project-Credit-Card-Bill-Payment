package com.cg.creditcardbillpayment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String username;

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + "]";
	}

	public Admin(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
