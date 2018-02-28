package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Product;
import com.niit.model.Supplier;


public class ProductDAOTest {
	static ProductDAO productDAO;
	@BeforeClass
	public static void preexecution() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		
	}
	@Ignore
	@Test
	public void addProductTest() {
		Product product=new Product();
		product.setProductName("dress");
		product.setProductDesc("top");
		assertTrue("problem inadding",productDAO.addProduct(product));

	}
	@Ignore
	@Test
	public void updateProductTest() {
		Product product=productDAO.getProduct(26);
		product.setProductDesc("cotton");
		assertTrue("problem in updateing",productDAO.updateProduct(product));
	}
	@Ignore	
	@Test
	public void deleteProductTest() {
		Product product=productDAO.getProduct(23);
		assertTrue("problem in deletong ",productDAO.deleteProduct(product));
	}
	
	@Test
	public void listproductsTest() {
	List<Product> listproducts=productDAO.listproducts();

		assertNotNull("problem in retriving",listproducts);
	}

}
