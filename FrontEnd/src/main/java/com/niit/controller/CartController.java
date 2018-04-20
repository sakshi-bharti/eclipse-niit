package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;

	@RequestMapping(value="/addToCart,{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m) {
		
		
	
		Cart cart = new Cart();
		
		cart.setProductId(productId);
		cart.setProductname(productDAO.getProduct(productId).getProductName());
		cart.setPrice(productDAO.getProduct(productId).getPrice());
		cart.setQuantity(quantity);
		cart.setStatus("NP");
		cart.setUsername((String)session.getAttribute("username"));
		
		cartDAO.addToCart(cart);
		
		List<Cart> listCartItem = cartDAO.listCartItem();
		m.addAttribute("cartItems",listCartItem);
		
		return "Cart";
		}
}

