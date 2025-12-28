package com.ilucky.idemo.util.sql;

/**
 * Mysql数据库工具类
 * @author IluckySi
 */
public class MysqlUtil extends SqlUtil {

	public static String url = "jdbc:mysql://10.0.3.42:3306/app?useUnicode=true&characterEncoding=utf8";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String user = "kevin";
	public static String password = "000000";

//	public static String url = "jdbc:mysql://10.0.1.77:3306/db_monitor_main";
//	// public static String url = "jdbc:mysql://10.0.1.77:3306/db_monitor_main?useUnicode=true&characterEncoding=utf8";
//
//	public static String driver = "com.mysql.jdbc.Driver";
//	public static String user = "jkb";
//	public static String password = "jkb";
	
	public MysqlUtil () {
		super(url, driver, user, password);
	}
	
	public MysqlUtil (String url, String driver, String user, String password) {
		super(url, driver, user, password);
	}

	/**
	 * 查询数据
	 */
//	public String selectJKB () {
//		Connection conn = getConnection();
//		String sql = "select * from international_conf";
//		StringBuilder sb = new StringBuilder();
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet result = pstmt.executeQuery();
//
//			while (result.next()) {
//				sb.append(result.getInt("ic_id") + "\t");
//				sb.append(result.getString("domain") + "\t");
//				String name = result.getString("name");
//				name = convertCharset(name);
//				sb.append(name + "\t");
//				String mailFromName = convertCharset(result.getString("mail_from_name"));
//				sb.append(mailFromName + "\r\n");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return sb.toString();
//	}
//
//
//// è¿™é‡Œæ˜¯äº§å“åç§°
//	public String convertCharset(String s)
//	{
//		String h = "è¿™é‡Œæ˜¯äº§å“\u0081å\u0090\u008Dç§°";
//		if (s != null)
//		{
//			try
//			{
//				int length = s.length();
//				byte[] buffer = new byte[length];
//				//0x81 to Unicode 0x0081, 0x8d to 0x008d, 0x8f to 0x008f, 0x90 to 0x0090, and 0x9d to 0x009d.
//				for (int i = 0; i < length; ++i)
//				{
//					char c = s.charAt(i);
//					if (c == 0x0081)
//					{
//						buffer[i] = (byte) 0x81;
//					}
//					else if (c == 0x008d)
//					{
//						buffer[i] = (byte) 0x8d;
//					}
//					else if (c == 0x008f)
//					{
//						buffer[i] = (byte) 0x8f;
//					}
//					else if (c == 0x0090)
//					{
//						buffer[i] = (byte) 0x90;
//					}
//					else if (c == 0x009d)
//					{
//						buffer[i] = (byte) 0x9d;
//					}
//					else
//					{
//						buffer[i] = Character.toString(c).getBytes("CP1252")[0];
//					}
//				}
//				String result = new String(buffer, "UTF-8");
//				return result;
//			}
//			catch (Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}

}