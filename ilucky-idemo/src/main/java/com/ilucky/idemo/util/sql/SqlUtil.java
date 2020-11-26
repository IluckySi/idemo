package com.ilucky.idemo.util.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * 数据库工具类: 支持增删改查
 * @author IluckySi
 */
public abstract class SqlUtil {

	public String url;
	public String driver;
	public String user;
	public String password;
	
	public SqlUtil(String url, String driver, String user, String password) {
		super();
		this.url = url;
		this.driver = driver;
		this.user = user;
		this.password = password;
	}

	/**
	 * 加载数据库驱动, 获取连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 插入数据
	 */
	public boolean insert(String name) {
		Connection conn = getConnection();
		String sql = "insert into apm_user(id, apm_user_name) values (?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			Random r = new Random();
			int id = r.nextInt(Integer.MAX_VALUE);
			System.out.println(id);

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			int t = pstmt.executeUpdate();
			System.out.println(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * 删除数据
	 */
	public boolean delete(String name) {
		Connection conn = getConnection();
		String sql = "delete from apm_user where apm_user_name= '" + name + "'";
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			int t = stmt.executeUpdate(sql);
			System.out.println(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 更新数据
	 */
	public boolean update(String name, String newName) {
		Connection conn = getConnection();
		String sql = "update apm_user set  apm_user_name=? where apm_user_name=?";
		System.out.println(sql);
		try {
			PreparedStatement  pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setString(2,  name);
			int t = pstmt.executeUpdate();
			System.out.println(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * 查询数据
	 */
	public String select() {
		Connection conn = getConnection();
		String sql = "select * from apm_user";
		StringBuilder sb = new StringBuilder();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet result = pstmt.executeQuery();

			while (result.next()) {
				sb.append(result.getInt("id") + "\t");
				sb.append(result.getString("apm_user_name") + "\r\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
