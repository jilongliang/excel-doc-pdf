package ivyy.taobao.com.utils;
/**
 *@DEMO:excel-doc-pdf
 *@Java：DBHelper.java
 *@Date:2015-1-10下午10:19:50
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *@DEMO:excel_doc_pdf
 *@Java：DbHelper.java
 *@Date:2015-1-10下午9:25:31
 *@Author:liangjilong
 *@Email:jilongliang@sina.com
 *@Weibo:http://weibo.com/jilongliang
 *@Version:1.0
 *@Description：DbHelper
 */
public class DBHelper {

	/**
	 * 设置单例
	 */
	public static DBHelper instance = new DBHelper();

	/**
	 * 设置单例的一个实例方法
	 * 
	 * @return
	 */
	public static DBHelper getInstance() {
		if (instance == null) {
			//锁定当前类
			synchronized (DBHelper.class) {
				instance = new DBHelper();
			}
		}
		return instance;
	}
	/**
	 * 得到MySql连接
	 * 
	 * @return
	 */
	public static Connection getMySqlConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/excel?useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "root";
		String driver="com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("连接数据库出现异常" + e.getMessage());
		}
		return conn;
	}

	/**
	 * 得到MSSQL连接
	 * @return
	 */
	public static Connection getMSSQLConnection() {
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=excel";
		String user = "sa";
		String password = "sa";
		String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Connection conn = null;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("连接数据库出现异常" + e.getMessage());
		}
		return conn;
	}
	
	
	/**
	 * 得到Oracle连接
	 * @return
	 */
	public static Connection getOracleConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:excel";
		String user = "scott";
		String password = "scott";
		String Driver="oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("连接数据库出现异常" + e.getMessage());
		}
		return conn;
	}
	 
	/***
	 * 释放资源...
	 * 
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void Relesae(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
