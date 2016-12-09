package com.luke.struts.action;

import java.util.List;

import com.luke.struts.entity.User;
import com.luke.struts.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	private User user = new User();
	private List<User> list;
	private UserService userService = new UserService();
	
	@Override
	public User getModel() {
		return user;
	}

	/*
	 * login check action
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String login() {
		try {
			User u = userService.login(user);
			if(u != null) {
				return "success";
			}
			return "login";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/*
	 * get user list action
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String list() {
		try {
			list = userService.getList();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/*
	 * get user by id and go to update page
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String toUpdate() {
		try {
			user = userService.getById(user.getId());
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/*
	 * update user infor action
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String update() {
		int result = userService.update(user);
		if(result > 0) {
			return "success";
		}
		return "error";
	}

	//------- All get and set ----------------------
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

}
