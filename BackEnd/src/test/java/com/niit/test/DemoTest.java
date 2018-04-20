package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;
import com.niit.dao.UserDetailDAO;
import com.niit.dao.UserDetailDAOImpl;

public class DemoTest {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		Category category=new Category();
		category.setCategoryname("Lenovo");
		category.setCategorydesc("Lenovo  mobile");
		categoryDAO.addCategory(category);
		
		
		
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		Supplier supplier=new Supplier();
		supplier.setSupplierName("sakshi");
		supplier.setSupplierAddrs("gaya");
		
		supplierDAO.addSupplier(supplier);
		
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		Product product=new Product();
		product.setProductName("lenovo");
		product.setProductDesc("android full hd phone");
		product.setPrice(2500);
		product.setStock(5);
		product.setSupplierId(201);
		productDAO.addProduct(product);
		
		
	UserDetailDAO userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	UserDetail userDetail=new UserDetail();
		userDetail.setUserName("sakshi");
	userDetail.setPassword("sa");
	userDetail.setAddress("gaya");
	userDetail.setRole("ADMIN");
	userDetail.setEmailId("sakshib@gmail.com");
	userDetail.setEnabled(false);
		userDetailDAO.registerUser(userDetail);
}
}

