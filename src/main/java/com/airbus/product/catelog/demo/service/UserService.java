package com.airbus.product.catelog.demo.service;

import com.airbus.product.catelog.demo.exceptions.IncorrectPasswordException;
import com.airbus.product.catelog.demo.exceptions.LoginException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.LoginDTO;

public interface UserService {

	public String loginUser(LoginDTO loginDTO) throws LoginException, UserNotFoundException, IncorrectPasswordException;
	public String registerUser(LoginDTO logindto);
}
