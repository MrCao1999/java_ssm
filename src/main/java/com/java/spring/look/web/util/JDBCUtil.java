package com.java.spring.look.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtil {
	static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);
	private static String JDBC_USER ="jdbc.user";
	private static String JDBC_PASSWORD="jbdc.password";
	private static String JDBC_URL="jbdc.url";
	private static String JDBC_CLASSNAME="jdbc.className";
	
	private static String USER;
	private static String PASSWORD;
	private static String URL;
	private static String CLASSNAME;
	private static String JDBC="jdbc";
	
	
	static {
		
		ResourceBundle bundle = ResourceBundle.getBundle(JDBC);
		USER = bundle.getString(JDBC_USER);
		PASSWORD = bundle.getString(JDBC_PASSWORD);
		URL = bundle.getString(JDBC_URL);
		CLASSNAME = bundle.getString(JDBC_CLASSNAME);
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(CLASSNAME);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			logger.info("已成功与数据库MySQL建立连接！！");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement pstm,ResultSet rs) {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(rs != null) {
				rs.close();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
}
