package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login_success")
	
	public String successfulLogin(){
		String page="AdminHome";

return page;

	}	
}
