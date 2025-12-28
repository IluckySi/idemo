package com.ilucky.idemo.util.sql;

/**
 * SqlServer数据库工具类:  sqljdbc-4.0.2206.100
 * @author IluckySi
 */
public class SqlServerUtil extends SqlUtil {

    public static String url = "jdbc:sqlserver://10.0.6.123:1433;DatabaseName=app;";
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String user = "sa";
    public static String password = "yunzhihui123";

    public SqlServerUtil() {
        super(url, driver, user, password);
    }

    public SqlServerUtil(String url, String driver, String user, String password) {
        super(url, driver, user, password);
    }
}
