package com.airbus.product.catelog.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.airbus.product.catelog.demo.exceptions.IncorrectPasswordException;
import com.airbus.product.catelog.demo.exceptions.LoginException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.LoginDTO;
import com.airbus.product.catelog.demo.models.User;
import com.airbus.product.catelog.demo.repositories.UserRepository;
import com.airbus.product.catelog.demo.utility.UserUtility;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	JWTTokenService jwtTokenService;
	
	@Autowired
	UserRepository userRepository;
	
     @Autowired
     PasswordEncoder passwordEncoder;
     
     @Autowired
     ModelMapper modelMapper;

	@Override
	public String loginUser(LoginDTO loginDTO) throws LoginException, UserNotFoundException, IncorrectPasswordException {
		
		UserUtility.loginValidation(loginDTO);
		
		Optional<User> optionalUser = userRepository.findByEmailId(loginDTO.getEmailId());
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		if (!passwordEncoder.matches(loginDTO.getPassword(), optionalUser.get().getPassword())) {
			throw new IncorrectPasswordException("Password is incorrect");
		}
		System.out.println("optional user id: "+optionalUser.get().getId() );
		return jwtTokenService.jwtTokenGenerator(optionalUser.get().getId());
		
	}
	
	public String registerUser(LoginDTO logindto) {
		User user = modelMapper.map(logindto, User.class);
		user.setPassword(passwordEncoder.encode(logindto.getPassword()));
		userRepository.save(user);
		return "Success";
		
	}

}
