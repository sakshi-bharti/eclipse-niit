package com.niit.controller;



import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Controller
public class LoginController {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/login_success" ,method=RequestMethod.POST)
	public String loginsuccess(HttpSession session,Model m){
		String page=null;
		
		boolean loggedIn=false;
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		System.out.println("login-success");
		//System.out.println(authentication.getName());
		//--> Retriving UserName
		String username=authentication.getName();
		
		//-->Retriving Role
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			System.out.println(role.getAuthority());
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);

	
			}
			else
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				List<Product> listproducts=productDAO.listproducts();
			    m.addAttribute("listproducts",listproducts);
			}
		}

return page;
	}
	@RequestMapping("/perform_login")
	public String performlogin(HttpSession session,Model m) {
		
	String page="AdminHome";

	return page;
	}
	
	
	
	
}

