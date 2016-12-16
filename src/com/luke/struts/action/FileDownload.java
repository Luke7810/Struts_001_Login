package com.luke.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.luke.struts.entity.User;
import com.luke.struts.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FileDownload extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService userService = new UserService();
	
	private String fileName;

	
	@Override
	public User getModel() {
		return user;
	}

	
	public InputStream getDownload() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			user = userService.getById(user.getId());
			String filePath = request.getRealPath("")+user.getFilePath().replace("/", "\\");
			String tempName = user.getFileName();
			fileName = tempName;

			File file = new File(filePath+"\\"+fileName);
			InputStream is = new FileInputStream(file);

			return is ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
