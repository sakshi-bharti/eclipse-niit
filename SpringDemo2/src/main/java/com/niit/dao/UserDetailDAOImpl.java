package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

public class UserDetailDAOImpl implements UserDetailDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
public boolean registerUser(UserDetail userDetail) {
		try {
		sessionFactory.getCurrentSession().save(userDetail);
		return true;
	}catch(Exception e) {
		System.out.println("exception arised"+e);
		return false;
	}
	}
@Transactional
	public boolean updateUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	}

	public UserDetail getUser(String userName) {
		Session session=sessionFactory.openSession();
		UserDetail userDetail=(UserDetail)session.get(UserDetail.class, userName);
		return userDetail;
	}
@Transactional
	public boolean approveUser(UserDetail userDetail) {
		try {
			sessionFactory.getCurrentSession().delete(userDetail);
			return true;
		}catch(Exception e) {
			System.out.println("exception arised"+e);
			return false;
		}
	}

}
