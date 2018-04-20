package com.niit.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDetailDAOTest {
	
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
		
	}
	
	@Ignore
	@Test
	public void registerUserTest() {
		BCryptPasswordEncoder passwordencoder= new BCryptPasswordEncoder();
		String password = passwordencoder.encode("sa");
		
		UserDetail userDetail=new UserDetail();
		userDetail.setUserName("Tharun");
		
		userDetail.setPassword(password);
		userDetail.setAddress("gaya");
		userDetail.setRole("ROLE_ADMIN");
		userDetail.setEnabled(true);
		userDetail.setEmailId("aku11@gmail.com");
		
		
		assertTrue("problm in registering",userDetailDAO.registerUser(userDetail));
		
		
	}

@Ignore	
@Test
public void updateUserTest() {
	UserDetail userDetail=userDetailDAO.getUser("akansha");
	userDetail.setAddress("gaya");
	userDetail.setEnabled(true);
	assertTrue("problem in updating",userDetailDAO.updateUser(userDetail));
}
	@Ignore
	@Test
	public void approveUser() {
		UserDetail userDetail=userDetailDAO.getUser("gudiya");
		
		assertTrue("problem in deleting",userDetailDAO.approveUser(userDetail));
	}
	
}
