package com.niit.dao;

import java.util.List;

import com.niit.model.UserDetail;

public interface UserDetailDAO {
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String userName);
	public boolean approveUser(UserDetail userDetail);
	

}
