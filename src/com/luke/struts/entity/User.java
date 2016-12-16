package com.luke.struts.entity;


public class User {
	private int id;
	private String username;
	private String userpwd;
	private String filePath;
	private String fileName;
	
	
	public User() {
		super();
	}
	


	public User(int id, String username, String userpwd, String filePath,
			String fileName) {
		super();
		this.id = id;
		this.username = username;
		this.userpwd = userpwd;
		this.filePath = filePath;
		this.fileName = fileName;
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


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
