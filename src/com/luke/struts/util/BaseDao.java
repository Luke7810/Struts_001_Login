package com.luke.struts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	
	private static final String BASEDAO_DBURL = "jdbc:mysql://localhost:3306/struts_user";
	private static final String BASEDAO_USERNAME = "root";
	private static final String BASEDAO_PWD = "root";
	private static final String BASEDAO_DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	/**
	 * 得到connection
	 * @return
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(BASEDAO_DRIVER);
			//System.out.println("Success loading Mysql Driver!");
			conn = DriverManager
						.getConnection(BASEDAO_DBURL, BASEDAO_USERNAME , BASEDAO_PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取ResultSet
	 * @param sql
	 * @return
	 */
	public ResultSet getResultSet(String sql) {
		conn = getConn();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 更新操作
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql) {
		int num = 0;
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return num;
	}

	/**
	 * 更新操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object...params) {
		int num = 0;
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			num = pstmt.executeUpdate();
 		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return num;
	}

	/**
	 * 批量更新操作
	 * @param sql
	 * @param paramList
	 */
	public void executeUpdate(String sql, List<Object[]> paramList) {
		Connection conn = getConn();
		int num = 0;
		try {
			conn.setAutoCommit(false);
			for (Object[] params : paramList) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				pstmt.executeUpdate();
				num++;
			}
			conn.commit();
			System.out.println("批量操作 --> " + num + " 条数据");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
	}

	/**
	 * 查询操作
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object... params) {
		conn = getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 关闭连接
	 */
	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

