package com.ilucky.idemo.controller;

import com.ilucky.idemo.util.sql.MysqlUtil;
import com.ilucky.idemo.util.sql.OracleUtil;
import com.ilucky.idemo.util.sql.SqlUtil;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据库
 */
@RestController
@RequestMapping("/sql")
public class SqlController {

    @RequestMapping(value="/mysql/{name}")
    public String mysql(@PathVariable("name") String name) {
        try {
            MysqlUtil sqlUtil = new MysqlUtil();
            executeSql(sqlUtil, name);
            return "mysql(" + name +")";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // 循环操作数据库
    @RequestMapping(value="/mysql/{count}/{name}")
    public String mysql(@PathVariable("count") int count,
        @PathVariable("name") String name) {
        try {
            MysqlUtil sqlUtil = new MysqlUtil();
            for (int i = 0; i < count; i++) {
                executeSql(sqlUtil, name + "_" + UUID.randomUUID());
            }
            return "mysql(" + count + ", " + name +")";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

//    @RequestMapping(value="/oracle")
//    public void oracle(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            OracleUtil sqlUtil = new OracleUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "oracle");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/postgresql")
//    public void postgresql(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            PostgresqlUtil sqlUtil = new PostgresqlUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "postgresql");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/mariadb")
//    public void mariadb(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            MariadbUtil sqlUtil = new MariadbUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "mariadb");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/sqlserver")
//    public void sqlserver(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            SqlServerUtil sqlUtil = new SqlServerUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "sqlserver");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/db2")
//    public void db2(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            OracleUtil sqlUtil = new OracleUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "db2");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/clickhouse")
//    public void clickhouse(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            ClickHouseUtil sqlUtil = new ClickHouseUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "clickhouse");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/jedis")
//    public void jedis(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            ClickHouseUtil sqlUtil = new ClickHouseUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "jedis");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value="/xmemcached")
//    public void xmemcached(HttpServletRequest request, HttpServletResponse response,
//        @RequestParam(value = "name", required = false) String name) {
//        try {
//            ClickHouseUtil sqlUtil = new ClickHouseUtil();
//            executeSql(sqlUtil, name);
//            CommonService.commonService(response, "xmemcached");
//        } catch (Exception e) {
//            CommonService.commonService(response, e.getMessage());
//        }
//    }

    private void executeSql(SqlUtil sqlUtil, String name) {
        sqlUtil.insert(name);
        sqlUtil.select();
        sqlUtil.delete(name);
        sqlUtil.select();
        if (sqlUtil instanceof OracleUtil) {
            ((OracleUtil) sqlUtil).insert2(name);
            ((OracleUtil) sqlUtil).insert3(name);
            ((OracleUtil) sqlUtil).update(name);
        }
    }
}
