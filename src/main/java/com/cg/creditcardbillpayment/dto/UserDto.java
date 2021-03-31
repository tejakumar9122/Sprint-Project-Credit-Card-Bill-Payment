package com.cg.creditcardbillpayment.dto;

public class UserDto {
	private String userId;
	private String oldPassword;
	private String newPassword;

	public UserDto() {
		super();
	}

	/**
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 */
	public UserDto(String userId, String oldPassword, String newPassword) {
		super();
		this.userId = userId;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}

}
