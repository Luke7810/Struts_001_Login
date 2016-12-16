package com.luke.struts.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.luke.struts.entity.User;
import com.luke.struts.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	private User user = new User();
	private List<User> list;
	private UserService userService = new UserService();
	private InputStream inputStream;
	
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
	public String listUsers() {
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
	
	/*
	 * delete user infor action
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String delete() {
		int result = userService.delete(user);
		if(result > 0) {
			return "success";
		}
		return "error";
	}

	/*
	 * check user exist
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String checkUserName () {
		 Map<String,Object> map = new HashMap<String,Object>();
		 
		 int result = userService.checkUser(user);
		 
		 if(result > 0){
			 map.put("valid", false);
		 }else{
			 map.put("valid", true);
		 }
		 String jsonString = JSON.toJSONString(map);
		 try {
			inputStream = new ByteArrayInputStream(jsonString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	/*
	 * Add user infor action
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public String add() {
		int result = userService.add(user);
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
