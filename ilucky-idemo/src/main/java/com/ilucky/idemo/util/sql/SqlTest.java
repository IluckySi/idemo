package com.ilucky.idemo.util.sql;

/**
 * 数据库测试
 * @author IluckySi
 * 
 */
public class SqlTest {

	public static void main(String[] args) {
		testMysqlUtil();
//		testOracleUtil();
//		testPostgresqlUtil();
//		testMariadbUtil();
//		testSqlServerUtil();
//		testClickHouseUtil();
	}

	private static void testOracleUtil() {
		SqlUtil sqlUtil = new OracleUtil();
		test(sqlUtil);
	}

	private static void testMysqlUtil() {
		MysqlUtil sqlUtil = new MysqlUtil();
		test(sqlUtil);
	}
	
	private static void testPostgresqlUtil() {
		PostgresqlUtil sqlUtil = new PostgresqlUtil();
		test(sqlUtil);
	}

	private static void testMariadbUtil() {
		MariadbUtil sqlUtil = new MariadbUtil();
		test(sqlUtil);
	}

	private static void testSqlServerUtil() {
		SqlServerUtil sqlUtil = new SqlServerUtil();
		test(sqlUtil);
	}
	
	private static void testClickHouseUtil() {
		ClickHouseUtil sqlUtil = new ClickHouseUtil();
		test(sqlUtil);
	}
	
	private static void test (SqlUtil sqlUtil) {
		try {
			System.out.println(sqlUtil.insert(SqlConsts.TEST_NAME));
			System.out.println("----------------");
			System.out.println(sqlUtil.select());
			System.out.println("----------------");
			System.out.println(sqlUtil.update(SqlConsts.TEST_NAME, SqlConsts.TEST_NEW_NAME));
			System.out.println("----------------");
			System.out.println(sqlUtil.select());
			System.out.println("----------------");
			System.out.println(sqlUtil.delete(SqlConsts.TEST_NEW_NAME));
			System.out.println("----------------");
			System.out.println(sqlUtil.select());
			System.out.println("----------------");
			
			if (sqlUtil instanceof OracleUtil) {
				((OracleUtil) sqlUtil).insert2(SqlConsts.TEST_NAME);
				((OracleUtil) sqlUtil).insert3(SqlConsts.TEST_NAME);
				((OracleUtil) sqlUtil).update(SqlConsts.TEST_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private static void test2 (SqlUtil sqlUtil) {
//		try {
//			System.out.println(((MysqlUtil)sqlUtil).selectJKB());
//			System.out.println("----------------");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
