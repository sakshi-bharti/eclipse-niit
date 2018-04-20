package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;
import com.niit.model.Category;



public class CartDAOTest {

	static CartDAO cartDAO;

	@BeforeClass
	public static void preExecution(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	@Ignore
		@Test
		public void addToCartTest() {
			Cart cart=new Cart();
			cart.setProductId(569);
			cart.setProductname("Iphone 4s");
			cart.setQuantity(1);
			cart.setStatus("NP");
			cart.setUsername("sakshi");
			cart.setPrice(11000);
			assertTrue("problem in insertion",cartDAO.addToCart(cart));
			
		}
	@Ignore	
		@Test
		public void updateCartTest() {
			Cart cart=cartDAO.getCart(630);
			cart.setQuantity(3);
			
			assertTrue("problem in updating",cartDAO.updateItemFromCart(cart));

		}
	@Ignore	
	@Test
	public void deleteCartTest() {
		Cart cart=cartDAO.getCart(629);
		
		assertTrue("problem in delerting",cartDAO.deleteItemFromCart(cart));
		
	}
		
	
	@Test
	public void listCart() {
		List<Cart> listCart=cartDAO.listCartItem();
		
		assertNotNull("problem in retriving",cartDAO.listCartItem());
	}
}
