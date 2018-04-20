package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional

	public boolean addCategory(Category category) {
		try {
			
			
			sessionFactory.getCurrentSession().save(category);
			
			return true;
			} catch(Exception e) {
				System.out.println("exception arised"+e);
				return false;
			}
		
	}
@Transactional
	public boolean updateCategory(Category category) {
try {
			
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
			} catch(Exception e) {
				System.out.println("exception arised"+e);
				return false;
			}
	}
@Transactional
	public boolean deleteCategory(Category category) {
try {
			
			
			sessionFactory.getCurrentSession().delete(category);
			
			return true;
			} catch(Exception e) {
				System.out.println("exception arised"+e);
				return false;
			}
	}

	public Category getCategory(int categoryid) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryid);
		return category;
	}

	public List<Category> listCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		session.close();
		return listCategories;
	}
	

}
