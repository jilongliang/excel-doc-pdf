package ivyy.taobao.com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

/**
 * 读取配置的数据库连接可读性较好!
 * @author liangjilong
 */
public class ConfigDbHelper {

	protected static Properties pro = null;
	protected static InputStream is = null;
	protected static Connection conn = null;

	public static ConfigDbHelper helper = null;

	/**
	 * 设置单例
	 * @return
	 */
	public static ConfigDbHelper getInstance() {
		if(helper==null){
			synchronized (ConfigDbHelper.class) {
				helper=new ConfigDbHelper();
			};
		}
		return helper;
	}

	/**
	 * 得到连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		String driver = ConfigDbHelper.getConfigKey("driver");
		String url = getConfigKey("url");
		String username = getConfigKey("username");
		String password = getConfigKey("password");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 得到配置的key
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfigKey(String key) {
		String strVal = "";
		try {
			String filePath=ConfigDbHelper.class.getClassLoader().getResource("prop/jdbc_config.properties").getPath();
			is = new FileInputStream(new File(filePath));
			pro = new Properties();
			pro.load(is);
			PropertyConfigurator.configure(pro);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		strVal = (String) pro.getProperty(key);
		return strVal;
	}

	/**
	 * 释放资源
	 */
	public static void ReleaseSoucre(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
