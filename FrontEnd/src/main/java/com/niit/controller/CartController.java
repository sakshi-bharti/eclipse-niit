
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
	@RequestMapping(value="/Cart")
	public String cartPage(HttpSession session,Model m) {
		
		String username = (String)session.getAttribute("username");
		
		List<Cart> listCartItem = cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItem);
		
		m.addAttribute("totalAmount",this.calcTotalAmount(listCartItem));
		m.addAttribute("cartsize",listCartItem.size());
		
		return "Cart";
	}


	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,HttpSession session,Model m) {
		
		String username = (String)session.getAttribute("username");
		
	
		Cart cart = new Cart();
		
		cart.setProductId(productId);
		cart.setProductname(productDAO.getProduct(productId).getProductName());
		cart.setPrice(productDAO.getProduct(productId).getPrice());
		cart.setQuantity(quantity);
		cart.setStatus("NP");
		cart.setUsername(username);
		
		cartDAO.addToCart(cart);
		
		List<Cart> listCartItem = cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItem);
		List<Cart> listCartItem1 = cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItem1);
		m.addAttribute("totalAmount",this.calcTotalAmount(listCartItem1));
		m.addAttribute("cartsize",listCartItem.size());
		
		
		return "Cart";
	}
	
	
	@RequestMapping(value="/updateCart/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,HttpSession session,Model m) {
		String username = (String)session.getAttribute("username");
		
	Cart cart=cartDAO.getCart(cartItemId);
	cart.setQuantity(quantity);
	cartDAO.updateItemFromCart(cart);
	List<Cart> listCartItems=cartDAO.listCartItem(username);
	m.addAttribute("cartItems",listCartItems);
	m.addAttribute("totalAmount",this.calcTotalAmount(listCartItems));
	m.addAttribute("cartsize",listCartItems.size());
	
	return "Cart";
		
	}
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,HttpSession session,Model m) {
		String username = (String)session.getAttribute("username");
		
		Cart cart=cartDAO.getCart(cartItemId);
		cartDAO.deleteItemFromCart(cart);
		
		
		List<Cart> listCartItems=cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItems);
		m.addAttribute("totalAmount",this.calcTotalAmount(listCartItems));
		m.addAttribute("cartsize",listCartItems.size());
		
		return "Cart";
	
	}
		
	
		public int calcTotalAmount(List<Cart> cartItems) {
			int item=0,totalAmount=0;
			while(item<cartItems.size()) {
				Cart cart = cartItems.get(item);
				totalAmount = totalAmount+(cart.getPrice()*cart.getQuantity());
				item++;
			}
			return totalAmount;
		}
		}


