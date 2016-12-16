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
		String sql = "select id, username, userpwd, filePath, fileName from admininfor where username=? and userpwd=?";
		ResultSet rs = this.executeQuery(sql, u.getUsername(), u.getUserpwd());
		try {
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
		String sql = "select id, username, userpwd, filePath, fileName from admininfor";
		List<User> list = new ArrayList<User>();
		ResultSet rs = this.executeQuery(sql);
		try {
			while(rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
		String sql = "select id, username, userpwd, filePath, fileName  from admininfor where id=?";
		ResultSet rs = this.executeQuery(sql, id);
		try {
			if(rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
		try {
			return this.executeUpdate(sql, user.getUsername(),user.getUserpwd(),user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			this.closeAll();
		}
	}

	/*
	 * Delete user information
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public int delete(User user) {
		String sql = "delete from admininfor where id=?";
		try {
			return this.executeUpdate(sql, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			this.closeAll();
		}
	}

	/*
	 * Retrun user number
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public int checkUserName(User user) {
		String sql = "select count(*) from admininfor where username=?";
		ResultSet rs = this.executeQuery(sql, user.getUsername());
		try {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return 0;
	}

	/*
	 * add user
	 * @author : Luke;
	 * @date: 12/09/2016
	 * 
	 * */
	public int addUser(User user) {
		String sql = "INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`, `filePath`, `fileName`) VALUES (NULL, ?, ?, ?, ?)";
		
		try {
			return this.executeUpdate(sql, user.getUsername(),user.getUserpwd(),user.getFilePath(), user.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return 0;
	}
}
