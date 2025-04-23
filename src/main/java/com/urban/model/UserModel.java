package com.urban.model;

import java.time.LocalDate;

public class UserModel {
	private int userId;
	private String userNumber;
	private String userName;
	private String userEmail;
	private String role;
	private String gender;
	private LocalDate dob;
	private String password;
	private String imageUrl;
	
	public UserModel() {
		
	}
	
	public UserModel(String username, String pasword, String role) {
		this.userName = username;
		this.password = pasword;
		this.role = role;
	}
	
	public UserModel(String username, String pasword) {
		this.userName = username;
		this.password = pasword;
	}
	
	public UserModel(int userId, String userName, String userNumber, String userEmail, String gender) {
		this.userId = userId;
		this.userName = userName; 
		this.userNumber = userNumber; 
		this.userEmail = userEmail;
		this.gender = gender;
	}
	
	public UserModel(String userNumber, String userName, String userEmail, String gender, String role, String password, LocalDate dob ) {
		super();
		this.userNumber = userNumber;
		this.userName = userName;
		this.userEmail = userEmail;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.dob = dob;
	}
	
	public UserModel(String userNumber, String userName, String userEmail, String gender, String role, String password, LocalDate dob, String imageUrl ) {
		this.userNumber = userNumber;
		this.userName = userName;
		this.userEmail = userEmail;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.dob = dob;
		this.imageUrl = imageUrl;
	}
	
	public UserModel(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
