package com.luke.struts.entity;


public class User {
	public int id;
	public String username;
	public String userpwd;
	
	public User() {
		super();
	}


	public User(int id, String username, String userpwd) {
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
	}
	
	
	public User(String username, String userpwd) {
		super();
		this.username = username;
		this.userpwd = userpwd;
	}

	

	public User(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
	
}
