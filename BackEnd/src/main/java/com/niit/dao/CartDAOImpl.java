package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

@Transactional
	public boolean addToCart(Cart cart) {
	try {
		
		
		sessionFactory.getCurrentSession().save(cart);
		
		return true;
		} catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	
	}

	@Transactional
	public boolean deleteItemFromCart(Cart cart) {
try {
			
			
			sessionFactory.getCurrentSession().delete(cart);
			
			return true;
			} catch(Exception e) {
				System.out.println("exception arised"+e);
				return false;
			}
		
		
	}

	@Transactional
	public boolean updateItemFromCart(Cart cart) {
try {
			
			
			sessionFactory.getCurrentSession().update(cart);
			
			return true;
			} catch(Exception e) {
				System.out.println("exception arised"+e);
				return false;
			}
		
	
	}

@Transactional	
	public List<Cart> listCartItem() {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Cart where status=:paidstatus");
	query.setParameter("paidstatus","NP");
	
	List<Cart> listCartItem = query.list();
	session.close();
	return listCartItem;
	
	
	}

	@Transactional
	public Cart getCart(int cartItemId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart)session.get(Cart.class,cartItemId);
		session.close();
		return cart;
	}

}   