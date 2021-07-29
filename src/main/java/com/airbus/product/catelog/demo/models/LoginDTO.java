package com.airbus.product.catelog.demo.models;

public class LoginDTO {

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	String emailId;
	String password;
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
