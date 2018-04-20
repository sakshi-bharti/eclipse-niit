package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

@Controller
public class UserController {
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@RequestMapping(value="/Signup")
	public String signupPage(Model m) {
		
		UserDetail  userdetail = new UserDetail();
		m.addAttribute("userdetail",userdetail);
		
		System.out.print("return of signup page");
		return "Signup";
	}
	
	@RequestMapping(value="/InsertUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("userdetail")UserDetail user,Model m) {
		
		System.out.println(user.getPassword());
		String password = user.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		user.setPassword(hashedPassword);
		
		user.setEnabled(true);
		userDetailDAO.registerUser(user);
  		
		UserDetail user1 = new UserDetail();
		m.addAttribute(user1);
		
		return "index";
		
}
}