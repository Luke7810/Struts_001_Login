package com.luke.struts.action;

public class Login {
	private String username;
	private String pwd;
	
	public String validateLogin() {
		if(username.equals("luke") && pwd.equals("12345")){
			return "success";
		}else{
			return "failed";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
