package com.ilucky.idemo.util.sql;

/**
 * https://github.com/yandex/clickhouse-jdbc
 * @author IluckySi
 *
 */
public class ClickHouseUtil extends SqlUtil {

    public static String url = "jdbc:clickhouse://42.159.11.151:8123/tsb_main";
    public static String driver = "ru.yandex.clickhouse.ClickHouseDriver";
    public static String user = "";
    public static String password = "";
    
    public ClickHouseUtil() {
        super(url, driver, user, password);
    }
    
	public ClickHouseUtil(String url, String driver, String user, String password) {
		super(url, driver, user, password);
	}

}
