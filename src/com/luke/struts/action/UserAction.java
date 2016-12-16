package com.luke.struts.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.luke.struts.entity.User;
import com.luke.struts.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private List<User> list;
	private UserService userService = new UserService();
	private InputStream inputStream;

	private File file;
	// 文件名
	private String fileFileName;
	// 文件的类型
	private String fileContentType;

	@Override
	public User getModel() {
		return user;
	}

	/*
	 * login check action
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
	public String login() {
		try {
			User u = userService.login(user);
			if (u != null) {
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
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
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
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
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
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
	public String update() {
		int result = userService.update(user);
		if (result > 0) {
			return "success";
		}
		return "error";
	}

	/*
	 * delete user infor action
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
	public String delete() {
		int result = userService.delete(user);
		if (result > 0) {
			return "success";
		}
		return "error";
	}

	/*
	 * check user exist
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
	public String checkUserName() {
		Map<String, Object> map = new HashMap<String, Object>();

		int result = userService.checkUser(user);

		if (result > 0) {
			map.put("valid", false);
		} else {
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
	 * 
	 * @author : Luke;
	 * 
	 * @Date: 12/09/2016
	 */
	public String add() {
		int randomPath = (int) (Math.random() * 100);
		HttpServletRequest request = ServletActionContext.getRequest();
		String tempPath = "/upload/" + randomPath;
		String path = request.getRealPath(tempPath);
		File filePath = new File(path);
		
		System.out.println("*****"+fileFileName);
		System.out.println("*****"+path);

		try {
			if (fileFileName != null) {
				if (!filePath.exists() && !filePath.isDirectory()) {
					filePath.mkdir();
				}

				InputStream is = new FileInputStream(file);
				OutputStream os = new FileOutputStream(new File(path,
						fileFileName));
				byte[] buffer = new byte[200];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
				if (os != null)
					os.close();
				if (is != null)
					is.close();
				user.setFilePath(tempPath);
				user.setFileName(fileFileName);
			} else {
				user.setFilePath("");
				user.setFileName("");
			}

			int result = userService.add(user);
			if (result > 0) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

	// ------- All get and set ----------------------
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
