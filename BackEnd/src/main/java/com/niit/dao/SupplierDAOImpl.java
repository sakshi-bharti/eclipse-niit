package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;


public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional

	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
			
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
		
	}
	@Transactional
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
			
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	}
	@Transactional
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
			
		}catch(Exception e) {
			
			System.out.println("exception arised"+e);
			return false;
		}
	}

	public Supplier getSupplier(int supplierid) {
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierid);
		return supplier;
		
	}

	public List<Supplier> listSuppliers() {
		Session session=sessionFactory.openSession();
		Query query=(Query)session.createQuery("from Supplier");
		List<Supplier> listsuppliers=query.list();
		session.close();
		return listsuppliers;
		
	}

}
