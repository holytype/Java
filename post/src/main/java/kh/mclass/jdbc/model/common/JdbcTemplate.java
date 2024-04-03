package kh.mclass.jdbc.model.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	
	public static Connection getConnection(boolean isLocalhost) {
		Connection conn = null;
		Properties prop = new Properties();

		try {
			if(isLocalhost) {
				prop.load(new FileReader(JdbcTemplate.class.getResource("./").getPath()+"driver.properties"));
				Class.forName(prop.getProperty("jdbc.driver"));
				conn = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.semi.username"),prop.getProperty("jdbc.semi.password"));
				
			} else {
				// to do
			}
			
			if(conn != null)
				System.out.println("JdbcTemplate conn not null");
			else
				System.out.println("JdbcTemplate conn is null");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void setAutoCommit(Connection conn, boolean value) {
		try {
			if(conn != null)
				conn.setAutoCommit(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null)
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null)
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
