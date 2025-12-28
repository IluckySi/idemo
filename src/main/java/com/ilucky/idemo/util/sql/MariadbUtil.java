package com.ilucky.idemo.util.sql;

/**
 * Mariadb数据库工具类
 * @author IluckySi
 */
public class MariadbUtil extends SqlUtil {

	public static String url ="jdbc:mariadb://10.0.1.225:3306/app";
	public static String driver = "org.mariadb.jdbc.Driver";
	public static String user = "root";
	public static String password = "123456";

	public MariadbUtil () {
		super(url, driver, user, password);
	}
	
	public MariadbUtil (String url, String driver, String user, String password) {
		super(url, driver, user, password);
	}
}