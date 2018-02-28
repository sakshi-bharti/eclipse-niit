package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTest {
	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void preExecution() {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	@Ignore
	@Test
          public void addSupplierTest() {
        	  Supplier supplier=new Supplier();
        	  supplier.setSupplierName("gudiya");
        	  supplier.setSupplierAddrs("vizag");
        	 
        	  assertTrue("problem in adding",supplierDAO.addSupplier(supplier));
	
      }
	
	@Ignore
	@Test
	public void updateSupplier() {
		Supplier supplier=supplierDAO.getSupplier(9);
		supplier.setSupplierName("suman");
		 assertTrue("problem in update",supplierDAO.updateSupplier(supplier));
			
		
	}
	@Ignore
	@Test
	public void deleteSupplier() {
		Supplier supplier=supplierDAO.getSupplier(10);
		assertTrue("problem in deleting",supplierDAO.deleteSupplier(supplier));
		
	}
@Test
public void listSuppliers() {

	assertNotNull("problem in retriving",supplierDAO.listSuppliers());
	
}
}