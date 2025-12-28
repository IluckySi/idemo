package com.ilucky.idemo.util.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * Oracle数据库工具类
 * @author IluckySi
 */
public class OracleUtil extends SqlUtil {

	public static String url = "jdbc:oracle:thin:@10.0.1.44:1521:ORCL";
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String user = "app";
	public static String password = "app";

	public OracleUtil () {
		super(url, driver, user, password);
	}
	
	public OracleUtil (String url, String driver, String user, String password) {
		super(url, driver, user, password);
	}
	
	/**
	 * 测试Oracle脱敏
	 */
	public boolean insert2(String name) {
		Connection conn = getConnection();
		String sql = "insert into APM_USER2(id, apm_user_name, apm_user_name1, apm_user_name2, apm_user_name3, apm_user_name4, apm_user_name5, "
				+ "apm_user_name6, apm_user_name7, apm_user_name8, apm_user_name9) values (?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			Random r = new Random();
			int id = r.nextInt(Integer.MAX_VALUE);
			System.out.println(id);

			pstmt.setInt(1, id);
			for(int i=2; i<=11; i++) {
				pstmt.setString(i, name+r.nextInt(Integer.MAX_VALUE));
			}
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
	 * 测试Oracle脱敏
	 */
	public boolean insert3(String name) {
		Connection conn = getConnection();
		String sql = "insert into APM_USER3(id, apm_user_name, apm_time) values (?,?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			Random r = new Random();
			int id = r.nextInt(Integer.MAX_VALUE);
			System.out.println(id);

			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setDate(3, new Date(System.currentTimeMillis()));
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
	
	public boolean update(String name) {
		Connection conn = getConnection();
		String sql = "update APM_USER3 set apm_user_name=? where apm_user_name=? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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
}