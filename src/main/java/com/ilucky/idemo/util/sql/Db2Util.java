package com.ilucky.idemo.util.sql;

/**
 * Db2工具类
 * @author IluckySi
 */
public class Db2Util extends SqlUtil {

		public static String url ="jdbc:mariadb://10.0.1.225:3306/app";
		public static String driver = "com.ibm.db2.jcc.DB2Driver";
		public static String user = "root";
		public static String password = "123456";

		public Db2Util () {
			super(url, driver, user, password);
		}
		
		public Db2Util (String url, String driver, String user, String password) {
			super(url, driver, user, password);
		}
}
