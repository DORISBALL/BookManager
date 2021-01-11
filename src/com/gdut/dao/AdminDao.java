package com.gdut.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class AdminDao {
	public static String TABLE = "admininfo";
	public static String ALL_FIELD = "username, password";
	
	public static boolean check(String username,String password) throws ClassNotFoundException {
		boolean checkOK = false;
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "select " + ALL_FIELD +
				" from " + TABLE +
				" where username=? and password=?";
		try (Connection conn = DriverManager.getConnection(DBConnect.JDBC_URL, DBConnect.JDBC_USER, DBConnect.JDBC_PASSWORD);) {
			//预处理编译sql
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				//设置数据库的两个参数
				ps.setString(1, username);
				ps.setString(2, password);
				try (ResultSet result = ps.executeQuery()) {
					checkOK = result.next();
				}
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return checkOK;
	}
}
