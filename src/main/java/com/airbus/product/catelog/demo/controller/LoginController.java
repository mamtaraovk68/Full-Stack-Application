package com.airbus.product.catelog.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	 @GetMapping("/")
	    public String viewHomePage() {
	        return "index";
	    }
	 
	
}
