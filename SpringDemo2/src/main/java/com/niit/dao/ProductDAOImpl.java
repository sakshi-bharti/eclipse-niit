package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
import com.niit.model.Supplier;

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional


	public boolean addProduct(Product product) {
	try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}catch(Exception e) {
		System.out.println("exception arised"+e);
		return false;
	}
	}
@Transactional
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	}

	
	public List<Product> listproducts() {
		Session session=sessionFactory.openSession();
		Query query=(Query)session.createQuery("from Supplier");
		List<Product> listproducts=query.list();
		session.close();
		return listproducts;
	}
@Transactional
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	}

	public Product getProduct(int productId) {
	Session session=sessionFactory.openSession();
	Product product=(Product)session.get(Product.class,productId);
	return product;
	}
	

}