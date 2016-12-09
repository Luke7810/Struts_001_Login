package com.luke.struts.dao;

import com.luke.struts.entity.User;
import com.luke.struts.util.BaseDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao {
	/*
	 * Using user name and password check user information in DB
	 * @author : Luke;
	 * @Date: 12/09/2016
	 * 
	 * */
	public User login(User u) {
		String sql = "select id, username, userpwd from admininfor where username=? and userpwd=?";
		ResultSet rs = this.executeQuery(sql, u.getUsername(), u.getUserpwd());
		try {
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return null;
	}
	
	/*
	 * Get all user list from DB
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public List<User> getList() {
		String sql = "select id, username, userpwd from admininfor";
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list.size()>0?list:null;
	}
	
	/*
	 * Get user information by ID
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public User getById(int id) {
		String sql = "select id, username, userpwd from admininfor where id=?";
		ResultSet rs = this.executeQuery(sql, id);
		try {
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return null;
	}
	
	/*
	 * Update user information
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public int update(User user) {
		String sql = "update admininfor set username=?, userpwd=? where id=?";
		return this.executeUpdate(sql, user.getUsername(),user.getUserpwd(),user.getId());
	}
}
