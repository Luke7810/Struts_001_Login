package com.luke.struts.service;

import java.util.List;

import com.luke.struts.dao.UserDao;
import com.luke.struts.entity.User;

public class UserService {
	private UserDao userDao = new UserDao(); // Using DAO connect to DB
	
	/*
	 * login check
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public User login(User u) {
		return userDao.login(u);
	}
	
	/*
	 * get all user list
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public List<User> getList() {
		return userDao.getList();
	}

	/*
	 * get user by ID
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public User getById(int id) {
		return userDao.getById(id);
	}

	/*
	 * update user infor
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public int update(User user) {
		return userDao.update(user);
	}
}
