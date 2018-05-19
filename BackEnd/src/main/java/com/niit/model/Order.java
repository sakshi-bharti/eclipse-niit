package com.niit.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Myorder")
public class Order {

	@Id
	@GeneratedValue
	int orderId;
	
	String username;
	Date orderDate;
	int totalAmountPaid;
	String paymentMode;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmountPaid() {
		return totalAmountPaid;
	}
	public void setTotalAmountPaid(int totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
}