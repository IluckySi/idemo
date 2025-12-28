package com.ilucky.idemo.controller;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  数据库连接池
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController {

    public static String url = "jdbc:mysql://10.0.3.42:3306/app?useUnicode=true&characterEncoding=utf8";
    public static String driver = "com.mysql.jdbc.Driver";
    public static String user = "kevin";
    public static String password = "000000";
    public static DataSource ds = null;

    // dbcp
    @RequestMapping(value="/dbcp/{name}")
    public String dbcp(@PathVariable("name") String name) {
        dbcpPoolInit();
        if (ds == null) {
            return "BasicDataSource is null";
        }
        String result = sqlBusiness();
        return result;
    }

    private void dbcpPoolInit() {
        ds = new BasicDataSource();
        ((BasicDataSource)ds).setDriverClassName(driver);
        ((BasicDataSource)ds).setUsername(user);
        ((BasicDataSource)ds).setPassword(password);
        ((BasicDataSource)ds).setUrl(url);
        ((BasicDataSource)ds).setInitialSize(2);
        ((BasicDataSource)ds).setMaxTotal(10);
        ((BasicDataSource)ds).setMaxWaitMillis(10000);
    }

    // druid
    @RequestMapping(value="/druid/{name}")
    public String druid(@PathVariable("name") String name) {
        druidPoolInit();
        if (ds == null) {
            return "BasicDataSource is null";
        }
        String result = sqlBusiness();
        return result;
    }

    private void druidPoolInit() {
        try {
            Properties properties = new Properties();
            properties.put("driverClassName", driver);
            properties.put("url", url);
            properties.put("username", user);
            properties.put("password", password);
            properties.put("initialSize", 2);
            properties.put("maxActive", 10);
            properties.put("maxWait", 10000);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: c3p0

    // 模拟sql业务
    public String sqlBusiness() {
        try {
            Connection conn = ds.getConnection();
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
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
