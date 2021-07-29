package com.airbus.product.catelog.demo.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "myUserCollection")
@EntityScan
public class User {

	public User() {
		
	}
	public User(String id, String emailId, String password) {
		super();
		this.id =id;
		this.emailId = emailId;
		this.password = password;
	}

    @Id
    String id;
	String emailId;
	String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
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
