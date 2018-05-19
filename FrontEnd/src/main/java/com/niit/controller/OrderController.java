package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CartDAO;
import com.niit.dao.OrderDAO;
import com.niit.model.Cart;
import com.niit.model.Order;

@Controller
public class OrderController {
	
	
	@Autowired
	CartDAO cartDAO;
	@Autowired
	OrderDAO orderDAO;
	@RequestMapping(value="/CheckOut")
public String checkOut(HttpSession session,Model m) {
		String username = (String)session.getAttribute("username");
		
		List<Cart> listCartItem1 = cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItem1);
		m.addAttribute("totalAmount",this.calcTotalAmount(listCartItem1));
		return "OrderConfirm";
		
	}
	@RequestMapping(value="/proceed",method=RequestMethod.POST)
	public String proceed(@RequestParam("pmode")String pmode,HttpSession session, Model m) {
		
	Order order=new Order();
		String username=((String)session.getAttribute("username"));
		List<Cart> listCartItem1 = cartDAO.listCartItem(username);
		m.addAttribute("cartItems",listCartItem1);
		
		order.setPaymentMode(pmode);
		order.setUsername(username);
		order.setTotalAmountPaid(this.calcTotalAmount(listCartItem1));
		order.setOrderDate(new java.util.Date());
		
		return "ThankYou";
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
