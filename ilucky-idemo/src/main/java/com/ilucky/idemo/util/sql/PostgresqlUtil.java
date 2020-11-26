package com.ilucky.idemo.util.sql;

/**
 * Oracle数据库工具类
 * @author IluckySi
 */
public class PostgresqlUtil extends SqlUtil {

    private static String url = "jdbc:postgresql://10.0.1.21:5432/app";
    private static String driver = "org.postgresql.Driver";
    private static String user = "postgres";
    private static String password = "postgres";
    
	public PostgresqlUtil () {
		super(url, driver, user, password);
	}
	
	public PostgresqlUtil (String url, String driver, String user, String password) {
		super(url, driver, user, password);
	}
}
