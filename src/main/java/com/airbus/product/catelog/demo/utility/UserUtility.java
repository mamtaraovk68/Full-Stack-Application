package com.airbus.product.catelog.demo.utility;

import com.airbus.product.catelog.demo.exceptions.LoginException;
import com.airbus.product.catelog.demo.models.LoginDTO;

public class UserUtility {

	public UserUtility() {
		// TODO Auto-generated constructor stub
	}

	public static void loginValidation(LoginDTO loginDTO) throws LoginException {
		if(loginDTO.getEmailId() == null || loginDTO.getPassword() == "") {
			throw new LoginException("Email Id cannot be null");
		}
		if (loginDTO.getPassword() == null || loginDTO.getPassword() == "") {
			throw new LoginException("Password field cannot be empty");
		}
	}
	
	public static String jwtValidator() {
		
		
		return null;
		
		
	}
}
