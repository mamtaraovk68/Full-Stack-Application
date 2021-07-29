package com.airbus.product.catelog.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.airbus.product.catelog.demo.exceptions.IncorrectPasswordException;
import com.airbus.product.catelog.demo.exceptions.LoginException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.LoginDTO;
import com.airbus.product.catelog.demo.models.Response;
import com.airbus.product.catelog.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/welcome")
	public String showRegistrationForm(Model model) {
		System.out.println("inside welcome api");
		model.addAttribute("logindto", new LoginDTO());

		return "login";
	}

	/*
	 * @RequestMapping(value="/login" , method=RequestMethod.POST) public String
	 * login(@ModelAttribute("logindto") LoginDTO logindto, HttpServletResponse res,
	 * Model model) throws LoginException, UserNotFoundException,
	 * IncorrectPasswordException {
	 * 
	 * 
	 * 
	 * System.out.println("login method"); String token =
	 * userService.loginUser(logindto); Response responseDTO = new Response();
	 * responseDTO.setMessage("Login Sucessfull"); responseDTO.setStatus(2);
	 * res.setHeader(token, token);
	 * 
	 * // return new ResponseEntity<>(responseDTO,HttpStatus.OK); return "succes";
	 */

	
     @PostMapping("/login")
     public ModelAndView processRegister(LoginDTO logindto , Model model) throws LoginException, UserNotFoundException, IncorrectPasswordException {
    System.out.println("login method"); 
    ModelAndView modelAndView = new ModelAndView("login_success");
    	String token= userService.loginUser(logindto);
    	modelAndView.addObject("token", token);	 
    	 return modelAndView;
}

	@PostMapping("/register")
	public String register(@RequestBody LoginDTO logindto, HttpServletResponse res) {
		System.out.println("inside controller");
		return userService.registerUser(logindto);

	}

}
